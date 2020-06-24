package org.brokencodes.tutorials.ada.apis.endpoints.rds;

import org.brokencodes.tutorials.ada.apis.beans.rds.RdsBasicInformation;
import org.brokencodes.tutorials.ada.apis.services.apis.rds.IRdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/rds")
public class RdsEndpoint {

    @Autowired
    private IRdsService rdsService;

    @GetMapping("/information")
    public Flux<RdsBasicInformation> getRdsInformation() {
        return rdsService.getRdsBasicInformation()
                .log();
    }
}
