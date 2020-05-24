package org.brokencodes.tutorials.ada.apis.endpoints.compute.ec2.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.brokencodes.tutorials.ada.apis.beans.compute.ec2.InstanceStateCounter;

@Data
public class Ec2InstanceStateCounterResponse {

    @JsonProperty
    private InstanceStateCounter instanceStateCounter;

    public Ec2InstanceStateCounterResponse(InstanceStateCounter instanceStateCounter) {
        this.instanceStateCounter = instanceStateCounter;
    }

}
