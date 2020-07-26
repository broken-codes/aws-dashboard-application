package org.brokencodes.tutorials.ada.apis.services.impl.compute;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.*;
import lombok.RequiredArgsConstructor;
import org.brokencodes.tutorials.ada.apis.beans.compute.ec2.InstanceStateCounter;
import org.brokencodes.tutorials.ada.apis.beans.compute.ec2.InstanceStateCounterHelper;
import org.brokencodes.tutorials.ada.apis.beans.compute.ec2.TransitGatewaysInformation;
import org.brokencodes.tutorials.ada.apis.services.apis.compute.IEC2Service;
import org.brokencodes.tutorials.ada.apis.services.clients.AwsClientFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class EC2Service implements IEC2Service {

    @Value("${aws-dash.aws.region}")
    private String region;

    @Override
    public Mono<InstanceStateCounter> getInstanceStateCounter(String arn) {
        AmazonEC2 ec2Client = AwsClientFactory.ec2Client(arn, region);
        InstanceStateCounterHelper helper = InstanceStateCounterHelper.newInstance();
        ec2Client.describeInstances(new DescribeInstancesRequest()).getReservations().stream()
                .map(reservation -> reservation.getInstances().get(0))
                .map(Instance::getInstanceId)
                .map(instanceId -> getStateOf(instanceId, ec2Client))
                .forEach(helper::incrementCount);

        return Mono.just(helper.get());
    }

    @Override
    public Flux<TransitGatewaysInformation> getTransitGateways(String arn) {
        AmazonEC2 amazonEC2 = AwsClientFactory.ec2Client(arn, region);
        Stream<TransitGatewaysInformation> transitGatewaysInformationStream = amazonEC2.describeTransitGateways(new DescribeTransitGatewaysRequest())
                .getTransitGateways().stream()
                .map(transitGateway -> TransitGatewaysInformation.builder()
                        .id(transitGateway.getTransitGatewayId())
                        .ownerId(transitGateway.getOwnerId())
                        .state(transitGateway.getState())
                        .tags(transitGateway.getTags().stream()
                                .map(tag -> String.format("\"%s\": %s,", tag.getKey(), tag.getValue()))
                                .reduce((acc, kv) -> acc += kv)
                                .orElse("")
                        )
                        .arn(transitGateway.getTransitGatewayArn())
                        .createdOn(transitGateway.getCreationTime().toString())
                        .amazonSideAsn(transitGateway.getOptions() != null ? transitGateway.getOptions().getAmazonSideAsn() : null)
                        .defaultRouteTableAssociation(transitGateway.getOptions() != null ? transitGateway.getOptions().getDefaultRouteTableAssociation() : null)
                        .dsnSupport(transitGateway.getOptions() != null ? transitGateway.getOptions().getDnsSupport() : null)
                        .multicastSupport(transitGateway.getOptions() != null ? transitGateway.getOptions().getMulticastSupport() : null)
                        .propagationDefaultRouteTableId(transitGateway.getOptions() != null ? transitGateway.getOptions().getPropagationDefaultRouteTableId() : null)
                        .vpnEcmpSupport(transitGateway.getOptions() != null ? transitGateway.getOptions().getVpnEcmpSupport() : null)
                        .autoAcceptSharedAttachments(transitGateway.getOptions() != null ? transitGateway.getOptions().getAutoAcceptSharedAttachments() : null)
                        .build()
                );
        return Flux.fromStream(transitGatewaysInformationStream);
    }

    private InstanceState getStateOf(String instanceId, AmazonEC2 ec2Client) {
        DescribeInstancesRequest describeInstanceRequest = new DescribeInstancesRequest().withInstanceIds(instanceId);
        DescribeInstancesResult describeInstanceResult = ec2Client.describeInstances(describeInstanceRequest);
        return describeInstanceResult.getReservations().get(0).getInstances().get(0).getState();
    }

}
