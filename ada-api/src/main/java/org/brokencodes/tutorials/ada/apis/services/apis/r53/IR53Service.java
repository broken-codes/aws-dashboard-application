package org.brokencodes.tutorials.ada.apis.services.apis.r53;

import org.brokencodes.tutorials.ada.apis.beans.r53.HostedZoneBasicInformation;
import reactor.core.publisher.Flux;

public interface IR53Service {
    Flux<HostedZoneBasicInformation> getHostedZoneBasicInformation(String arn);
}
