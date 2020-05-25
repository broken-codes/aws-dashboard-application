package org.brokencodes.tutorials.ada.apis.endpoints.compute.ec2;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.brokencodes.tutorials.ada.apis.endpoints.compute.ec2.responses.Ec2InstanceStateCounterResponse;
import org.brokencodes.tutorials.ada.apis.services.apis.compute.IEC2Service;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api/compute/ec2")
public class EC2Endpoints {

    private final IEC2Service ec2Service;

    @GetMapping(value = "/instances/counter", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<Ec2InstanceStateCounterResponse> getInstancesStateCount() {
        return ec2Service.getInstanceStateCounter()
                .map(Ec2InstanceStateCounterResponse::new)
                .log();
    }

}
