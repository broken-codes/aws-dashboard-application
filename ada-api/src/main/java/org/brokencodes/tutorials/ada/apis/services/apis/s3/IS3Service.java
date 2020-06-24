package org.brokencodes.tutorials.ada.apis.services.apis.s3;

import org.brokencodes.tutorials.ada.apis.beans.s3.S3BasicInformation;
import reactor.core.publisher.Flux;

public interface IS3Service {

    Flux<S3BasicInformation> getS3BasicInformation();
}
