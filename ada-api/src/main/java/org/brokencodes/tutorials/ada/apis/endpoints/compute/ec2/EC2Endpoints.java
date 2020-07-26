package org.brokencodes.tutorials.ada.apis.endpoints.compute.ec2;

import lombok.RequiredArgsConstructor;
import org.brokencodes.tutorials.ada.apis.beans.compute.ec2.TransitGatewaysInformation;
import org.brokencodes.tutorials.ada.apis.endpoints.compute.ec2.responses.Ec2InstanceStateCounterResponse;
import org.brokencodes.tutorials.ada.apis.services.apis.compute.IEC2Service;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api/compute/ec2")
public class EC2Endpoints {

    private final IEC2Service ec2Service;

    @GetMapping(value = "/instances/counter", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<Ec2InstanceStateCounterResponse> getInstancesStateCount(@RequestParam("arn") String arn) {
        return ec2Service.getInstanceStateCounter(arn)
                .map(Ec2InstanceStateCounterResponse::new)
                .log();
    }

    @GetMapping(value = "/gateways/transit", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<TransitGatewaysInformation> getTransitGatewayInformation(@RequestParam("arn") String arn) {
        return ec2Service.getTransitGateways(arn)
                .log();
    }

}
