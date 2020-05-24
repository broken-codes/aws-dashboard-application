package org.brokencodes.tutorials.ada.apis.beans.compute.ec2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InstanceStateCounter {

    private int countPending;

    private int countRunning;

    private int countStopped;

    private int countStopping;

    private int countTerminated;

    private int countShuttingDown;

    private int countTotal;

}
