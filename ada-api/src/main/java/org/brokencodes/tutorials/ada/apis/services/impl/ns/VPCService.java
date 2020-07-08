package org.brokencodes.tutorials.ada.apis.services.impl.ns;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.DescribeVpcsRequest;
import lombok.RequiredArgsConstructor;
import org.brokencodes.tutorials.ada.apis.beans.ns.vpc.RouteTableInformation;
import org.brokencodes.tutorials.ada.apis.beans.ns.vpc.SubnetInformation;
import org.brokencodes.tutorials.ada.apis.beans.ns.vpc.VPCBasicInformation;
import org.brokencodes.tutorials.ada.apis.beans.ns.vpc.VpcPeeringConnectionInformation;
import org.brokencodes.tutorials.ada.apis.services.apis.ns.IVPCService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class VPCService implements IVPCService {

    private final AmazonEC2 ec2Client;

    @Override
    public Flux<VPCBasicInformation> getVPCInformation() {
        DescribeVpcsRequest describeVpcsRequest = new DescribeVpcsRequest();
        Stream<VPCBasicInformation> vpcInformationStream = ec2Client.describeVpcs(describeVpcsRequest)
                .getVpcs()
                .stream()
                .map(vpc -> VPCBasicInformation.builder()
                        .ipv4CIDR(vpc.getCidrBlock())
                        .vpcId(vpc.getVpcId())
                        .isDefaultVPC(vpc.isDefault())
                        .state(vpc.getState())
                        .build());
        return Flux.fromStream(vpcInformationStream);
    }

    @Override
    public Flux<SubnetInformation> getSubnetInformation() {
        Stream<SubnetInformation> subnetInformationStream = ec2Client.describeSubnets()
                .getSubnets()
                .stream()
                .map(subnet -> SubnetInformation.builder()
                        .ipv4Cidr(subnet.getCidrBlock())
                        .availabilityZone(subnet.getAvailabilityZone())
                        .availableIpv4AddressCount(subnet.getAvailableIpAddressCount())
                        .isDefaultForAz(subnet.isDefaultForAz())
                        .state(subnet.getState())
                        .ownerId(subnet.getOwnerId())
                        .subnetArn(subnet.getSubnetArn())
                        .build());
        return Flux.fromStream(subnetInformationStream);
    }

    @Override
    public Flux<RouteTableInformation> getRouteTableInformation() {
        Stream<RouteTableInformation> routeTableInformationStream = ec2Client.describeRouteTables().getRouteTables().stream()
                .map(routeTable -> RouteTableInformation.builder()
                        .routeTableId(routeTable.getRouteTableId())
                        .owner(routeTable.getOwnerId())
                        .vpcId(routeTable.getVpcId())
                        .build());
        return Flux.fromStream(routeTableInformationStream);
    }

    @Override
    public Flux<VpcPeeringConnectionInformation> getVpcPeeringConnectionInformation() {
        Stream<VpcPeeringConnectionInformation> vpcPeeringConnectionInformationStream = ec2Client.describeVpcPeeringConnections().getVpcPeeringConnections().stream()
                .map(vpcPeeringConnection -> VpcPeeringConnectionInformation.builder()
                        .id(vpcPeeringConnection.getVpcPeeringConnectionId())
                        .acceptingVpcId(vpcPeeringConnection.getAccepterVpcInfo().getVpcId())
                        .acceptingConnectionOwner(vpcPeeringConnection.getAccepterVpcInfo().getOwnerId())
                        .acceptingConnectionCidr(vpcPeeringConnection.getAccepterVpcInfo().getCidrBlock())
                        .acceptingRegion(vpcPeeringConnection.getAccepterVpcInfo().getRegion())
                        .acceptingAllowsDnsResolutionFromRemote(vpcPeeringConnection.getAccepterVpcInfo().getPeeringOptions().isAllowDnsResolutionFromRemoteVpc())
                        .acceptingAllowEgressFromLocalClassicLinkToRemoteVpc(vpcPeeringConnection.getAccepterVpcInfo().getPeeringOptions().getAllowEgressFromLocalClassicLinkToRemoteVpc())
                        .acceptingAllowEgressFromLocalVpcToRemoteClassicLink(vpcPeeringConnection.getAccepterVpcInfo().getPeeringOptions().getAllowEgressFromLocalVpcToRemoteClassicLink())

                        .requesterVpcId(vpcPeeringConnection.getRequesterVpcInfo().getVpcId())
                        .requesterConnectionOwner(vpcPeeringConnection.getRequesterVpcInfo().getOwnerId())
                        .requesterConnectionCidr(vpcPeeringConnection.getRequesterVpcInfo().getCidrBlock())
                        .requesterRegion(vpcPeeringConnection.getRequesterVpcInfo().getRegion())
                        .requesterAllowsDnsResolutionFromRemote(vpcPeeringConnection.getRequesterVpcInfo().getPeeringOptions().isAllowDnsResolutionFromRemoteVpc())
                        .requesterAllowEgressFromLocalClassicLinkToRemoteVpc(vpcPeeringConnection.getRequesterVpcInfo().getPeeringOptions().getAllowEgressFromLocalClassicLinkToRemoteVpc())
                        .requesterAllowEgressFromLocalVpcToRemoteClassicLink(vpcPeeringConnection.getRequesterVpcInfo().getPeeringOptions().getAllowEgressFromLocalVpcToRemoteClassicLink())

                        .validity(vpcPeeringConnection.getExpirationTime().toString())
                        .status(vpcPeeringConnection.getStatus().getMessage())

                        .build());
        return Flux.fromStream(vpcPeeringConnectionInformationStream);
    }

}
