package org.brokencodes.tutorials.ada.apis.beans.ns.vpc;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VPCBasicInformation {

    private String name;

    private String vpcId;

    private String state;

    private String ipv4CIDR;

    private boolean isDefaultVPC;

}
