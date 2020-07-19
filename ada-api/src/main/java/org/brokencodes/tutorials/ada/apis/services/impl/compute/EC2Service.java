package org.brokencodes.tutorials.ada.apis.services.impl.compute;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.DescribeInstancesRequest;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.InstanceState;
import lombok.RequiredArgsConstructor;
import org.brokencodes.tutorials.ada.apis.beans.compute.ec2.InstanceStateCounter;
import org.brokencodes.tutorials.ada.apis.beans.compute.ec2.InstanceStateCounterHelper;
import org.brokencodes.tutorials.ada.apis.services.apis.compute.IEC2Service;
import org.brokencodes.tutorials.ada.apis.services.clients.AwsClientFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

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

    private InstanceState getStateOf(String instanceId, AmazonEC2 ec2Client) {
        DescribeInstancesRequest describeInstanceRequest = new DescribeInstancesRequest().withInstanceIds(instanceId);
        DescribeInstancesResult describeInstanceResult = ec2Client.describeInstances(describeInstanceRequest);
        return describeInstanceResult.getReservations().get(0).getInstances().get(0).getState();
    }

}
