package org.brokencodes.tutorials.ada.apis.services.apis.rds;

import org.brokencodes.tutorials.ada.apis.beans.rds.RdsBasicInformation;
import reactor.core.publisher.Flux;

public interface IRdsService {

    Flux<RdsBasicInformation> getRdsBasicInformation(String arn);
}
