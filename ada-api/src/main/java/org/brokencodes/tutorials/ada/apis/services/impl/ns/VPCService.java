package org.brokencodes.tutorials.ada.apis.services.impl.ns;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.DescribeVpcsRequest;
import lombok.RequiredArgsConstructor;
import org.brokencodes.tutorials.ada.apis.beans.ns.vpc.VPCBasicInformation;
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

}
