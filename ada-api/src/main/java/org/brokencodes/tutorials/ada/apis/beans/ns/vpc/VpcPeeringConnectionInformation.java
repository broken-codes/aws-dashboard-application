package org.brokencodes.tutorials.ada.apis.beans.ns.vpc;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VpcPeeringConnectionInformation {

    private String id;

    private String acceptingVpcId;

    private String acceptingConnectionOwner;

    private String acceptingConnectionCidr;

    private String acceptingRegion;

    private boolean acceptingAllowsDnsResolutionFromRemote;

    private boolean requesterAllowsDnsResolutionFromRemote;

    private boolean acceptingAllowEgressFromLocalClassicLinkToRemoteVpc;

    private boolean requesterAllowEgressFromLocalClassicLinkToRemoteVpc;

    private boolean acceptingAllowEgressFromLocalVpcToRemoteClassicLink;

    private boolean requesterAllowEgressFromLocalVpcToRemoteClassicLink;

    private String requesterVpcId;

    private String requesterConnectionOwner;

    private String requesterConnectionCidr;

    private String requesterRegion;

    private String validity;

    private String status;

}
