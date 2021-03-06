package org.brokencodes.tutorials.ada.apis.services.impl.r53;

import com.amazonaws.services.route53.AmazonRoute53;
import lombok.extern.slf4j.Slf4j;
import org.brokencodes.tutorials.ada.apis.beans.r53.HostedZoneBasicInformation;
import org.brokencodes.tutorials.ada.apis.services.apis.r53.IR53Service;
import org.brokencodes.tutorials.ada.apis.services.clients.AwsClientFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.stream.Stream;

@Slf4j
@Service
public class R53Service implements IR53Service {

    @Value("${aws-dash.aws.region}")
    private String region;

    public Flux<HostedZoneBasicInformation> getHostedZoneBasicInformation(String arn) {
        AmazonRoute53 r53Client = AwsClientFactory.route53Client(arn, region);
        Stream<HostedZoneBasicInformation> hostedZoneBasicInformationStream = r53Client.listHostedZones().getHostedZones().stream()
                .peek(item -> log.info("Obtained hosted zone: {}", item))
                .map(hostedZone -> HostedZoneBasicInformation.builder()
                        .id(hostedZone.getId())
                        .callerReference(hostedZone.getCallerReference())
                        .isPrivateZone(hostedZone.getConfig().isPrivateZone())
                        .name(hostedZone.getName())
                        .resourceRecordSetCount(hostedZone.getResourceRecordSetCount())
                        .servicePrincipal(hostedZone.getLinkedService().getServicePrincipal())
                        .build());
        return Flux.fromStream(hostedZoneBasicInformationStream);
    }

}
