package org.brokencodes.tutorials.ada.apis.endpoints.s3;

import org.brokencodes.tutorials.ada.apis.beans.s3.S3BasicInformation;
import org.brokencodes.tutorials.ada.apis.services.apis.s3.IS3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/s3")
public class S3Endpoints {

    @Autowired
    private IS3Service s3Service;

    @GetMapping("/information")
    public Flux<S3BasicInformation> getRdsInformation(@RequestParam("arn") String arn) {
        return s3Service.getS3BasicInformation(arn)
                .log();
    }
}
