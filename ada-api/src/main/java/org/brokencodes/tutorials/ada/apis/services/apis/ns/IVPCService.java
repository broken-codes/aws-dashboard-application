package org.brokencodes.tutorials.ada.apis.services.apis.ns;

import org.brokencodes.tutorials.ada.apis.beans.ns.vpc.VPCBasicInformation;
import reactor.core.publisher.Flux;

public interface IVPCService {

    Flux<VPCBasicInformation> getVPCInformation();
}