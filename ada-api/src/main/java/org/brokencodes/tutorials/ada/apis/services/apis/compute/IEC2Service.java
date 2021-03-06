package org.brokencodes.tutorials.ada.apis.services.apis.compute;

import org.brokencodes.tutorials.ada.apis.beans.compute.ec2.InstanceStateCounter;
import org.brokencodes.tutorials.ada.apis.beans.compute.ec2.TransitGatewaysInformation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IEC2Service {

    Mono<InstanceStateCounter> getInstanceStateCounter(String arn);


    Flux<TransitGatewaysInformation> getTransitGateways(String arn);

}
