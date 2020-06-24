package org.brokencodes.tutorials.ada.apis.beans.rds;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RdsBasicInformation {

    private String dbId;

    private String engine;

    private String engineVersion;

    private String dbStatus;

    private String endpoint;

    private String availabilityZone;

    private String dbInstanceArn;

    private String instanceCreationTime;

    private String associatedVpcId;

    private String dbSubnetGroupName;
}
