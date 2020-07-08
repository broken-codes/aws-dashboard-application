package org.brokencodes.tutorials.ada.apis.endpoints.ns.vpc;

import lombok.RequiredArgsConstructor;
import org.brokencodes.tutorials.ada.apis.beans.ns.vpc.RouteTableInformation;
import org.brokencodes.tutorials.ada.apis.beans.ns.vpc.SubnetInformation;
import org.brokencodes.tutorials.ada.apis.beans.ns.vpc.VPCBasicInformation;
import org.brokencodes.tutorials.ada.apis.beans.ns.vpc.VpcPeeringConnectionInformation;
import org.brokencodes.tutorials.ada.apis.services.apis.ns.IVPCService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api/ns/vpc")
public class VPCEndpoints {

    private final IVPCService vpcService;

    @GetMapping("/info")
    public Flux<VPCBasicInformation> getVPCInformation() {
        return vpcService.getVPCInformation()
                .log();
    }

    @GetMapping("/subnets")
    public Flux<SubnetInformation> getSubnetInformation() {
        return vpcService.getSubnetInformation()
                .log();
    }

    @GetMapping("/route-tables")
    public Flux<RouteTableInformation> getRouteTableInformation() {
        return vpcService.getRouteTableInformation()
                .log();
    }

    @GetMapping("/vpc-peering")
    public Flux<VpcPeeringConnectionInformation> getVpcPeeringConnectionInformation() {
        return vpcService.getVpcPeeringConnectionInformation()
                .log();
    }
}
