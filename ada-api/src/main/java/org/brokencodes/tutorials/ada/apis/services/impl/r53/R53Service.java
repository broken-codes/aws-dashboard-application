package org.brokencodes.tutorials.ada.apis.services.impl.r53;

import com.amazonaws.services.route53.AmazonRoute53;
import org.brokencodes.tutorials.ada.apis.beans.r53.HostedZoneBasicInformation;
import org.brokencodes.tutorials.ada.apis.services.apis.r53.IR53Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.stream.Stream;

@Service
public class R53Service implements IR53Service {

    @Autowired
    private AmazonRoute53 r53Client;

    public Flux<HostedZoneBasicInformation> getHostedZoneBasicInformation() {
        Stream<HostedZoneBasicInformation> hostedZoneBasicInformationStream = r53Client.listHostedZones().getHostedZones().stream()
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
