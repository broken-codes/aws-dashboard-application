package org.brokencodes.tutorials.ada.apis.endpoints.r53;

import org.brokencodes.tutorials.ada.apis.beans.r53.HostedZoneBasicInformation;
import org.brokencodes.tutorials.ada.apis.services.apis.r53.IR53Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/r53")
public class R53Endpoints {

    @Autowired
    private IR53Service ir53Service;

    @GetMapping("/hosted-zones")
    public Flux<HostedZoneBasicInformation> getHostedZoneBasicInformation() {
        return ir53Service.getHostedZoneBasicInformation();
    }
}
