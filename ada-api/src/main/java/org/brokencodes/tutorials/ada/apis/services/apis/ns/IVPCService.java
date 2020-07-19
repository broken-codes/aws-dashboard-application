package org.brokencodes.tutorials.ada.apis.services.apis.ns;

import org.brokencodes.tutorials.ada.apis.beans.ns.vpc.RouteTableInformation;
import org.brokencodes.tutorials.ada.apis.beans.ns.vpc.SubnetInformation;
import org.brokencodes.tutorials.ada.apis.beans.ns.vpc.VPCBasicInformation;
import org.brokencodes.tutorials.ada.apis.beans.ns.vpc.VpcPeeringConnectionInformation;
import reactor.core.publisher.Flux;

public interface IVPCService {

    Flux<VPCBasicInformation> getVPCInformation(String arn);

    Flux<SubnetInformation> getSubnetInformation(String arn);

    Flux<RouteTableInformation> getRouteTableInformation(String arn);

    Flux<VpcPeeringConnectionInformation> getVpcPeeringConnectionInformation(String arn);
}
