package org.brokencodes.tutorials.ada.apis.beans.ns.vpc;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubnetInformation {

    private String availabilityZone;

    private String ipv4Cidr;

    private Integer availableIpv4AddressCount;

    private boolean isDefaultForAz;

    private String state;

    private String vpcId;

    private String ownerId;

    private String subnetArn;

}
