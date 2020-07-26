package org.brokencodes.tutorials.ada.apis.beans.compute.ec2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransitGatewaysInformation {

    private String id;

    private String ownerId;

    private String state;

    private String tags;

    private String arn;

    private String createdOn;

    private Long amazonSideAsn;

    private String defaultRouteTableAssociation;

    private String dsnSupport;

    private String multicastSupport;

    private String propagationDefaultRouteTableId;

    private String vpnEcmpSupport;

    private String autoAcceptSharedAttachments;

}
