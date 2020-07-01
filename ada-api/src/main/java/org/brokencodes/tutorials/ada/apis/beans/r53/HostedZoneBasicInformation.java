package org.brokencodes.tutorials.ada.apis.beans.r53;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HostedZoneBasicInformation {

    private String id;

    private String name;

    private String callerReference;

    private Long resourceRecordSetCount;

    private boolean isPrivateZone;

    private String servicePrincipal;
}
