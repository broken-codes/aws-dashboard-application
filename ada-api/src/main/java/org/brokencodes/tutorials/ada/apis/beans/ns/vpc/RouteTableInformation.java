package org.brokencodes.tutorials.ada.apis.beans.ns.vpc;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RouteTableInformation {

    private String routeTableId;

    private String vpcId;

    private String owner;

}
