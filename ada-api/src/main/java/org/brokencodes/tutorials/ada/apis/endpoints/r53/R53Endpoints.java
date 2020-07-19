package org.brokencodes.tutorials.ada.apis.endpoints.r53;

import lombok.extern.slf4j.Slf4j;
import org.brokencodes.tutorials.ada.apis.beans.r53.HostedZoneBasicInformation;
import org.brokencodes.tutorials.ada.apis.services.apis.r53.IR53Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@Slf4j
@RestController
@RequestMapping("/api/r53")
public class R53Endpoints {

    @Autowired
    private IR53Service ir53Service;

    @GetMapping("/hosted-zones")
    public Flux<HostedZoneBasicInformation> getHostedZoneBasicInformation(@RequestParam("arn") String arn) {
        log.info("Obtained request for displaying hosted zones");
        return ir53Service.getHostedZoneBasicInformation(arn)
                .log();
    }
}
