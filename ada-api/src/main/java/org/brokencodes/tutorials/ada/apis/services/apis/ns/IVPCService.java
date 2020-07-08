package org.brokencodes.tutorials.ada.apis.services.apis.ns;

import org.brokencodes.tutorials.ada.apis.beans.ns.vpc.RouteTableInformation;
import org.brokencodes.tutorials.ada.apis.beans.ns.vpc.SubnetInformation;
import org.brokencodes.tutorials.ada.apis.beans.ns.vpc.VPCBasicInformation;
import org.brokencodes.tutorials.ada.apis.beans.ns.vpc.VpcPeeringConnectionInformation;
import reactor.core.publisher.Flux;

public interface IVPCService {

    Flux<VPCBasicInformation> getVPCInformation();

    Flux<SubnetInformation> getSubnetInformation();

    Flux<RouteTableInformation> getRouteTableInformation();

    Flux<VpcPeeringConnectionInformation> getVpcPeeringConnectionInformation();
}
