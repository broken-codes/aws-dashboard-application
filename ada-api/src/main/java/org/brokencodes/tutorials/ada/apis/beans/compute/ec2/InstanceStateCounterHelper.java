package org.brokencodes.tutorials.ada.apis.beans.compute.ec2;

import com.amazonaws.services.ec2.model.InstanceState;
import org.brokencodes.tutorials.ada.apis.exceptions.UnknownInstanceStateObtainedException;

public class InstanceStateCounterHelper {

    private InstanceStateCounter instanceStateCounter;

    private InstanceStateCounterHelper() {
        // Do not instantiate outside
    }

    public static InstanceStateCounterHelper newInstance() {
        InstanceStateCounterHelper helper = new InstanceStateCounterHelper();
        helper.instanceStateCounter = new InstanceStateCounter();
        return helper;
    }

    public void incrementCount(InstanceState state) {
        Integer code = state.getCode();
        if (code == State.PENDING.state) {
            instanceStateCounter.setCountPending(instanceStateCounter.getCountPending() + 1);
            instanceStateCounter.setCountTotal(instanceStateCounter.getCountTotal() + 1);
        } else if (code == State.RUNNING.state) {
            instanceStateCounter.setCountRunning(instanceStateCounter.getCountRunning() + 1);
            instanceStateCounter.setCountTotal(instanceStateCounter.getCountTotal() + 1);
        } else if (code == State.SHUTTING_DOWN.state) {
            instanceStateCounter.setCountShuttingDown(instanceStateCounter.getCountShuttingDown() + 1);
            instanceStateCounter.setCountTotal(instanceStateCounter.getCountTotal() + 1);
        } else if (code == State.TERMINATED.state) {
            instanceStateCounter.setCountTerminated(instanceStateCounter.getCountTerminated() + 1);
            instanceStateCounter.setCountTotal(instanceStateCounter.getCountTotal() + 1);
        } else if (code == State.STOPPING.state) {
            instanceStateCounter.setCountStopping(instanceStateCounter.getCountStopping() + 1);
            instanceStateCounter.setCountTotal(instanceStateCounter.getCountTotal() + 1);
        } else if (code == State.STOPPED.state) {
            instanceStateCounter.setCountStopped(instanceStateCounter.getCountStopped() + 1);
            instanceStateCounter.setCountTotal(instanceStateCounter.getCountTotal() + 1);
        } else {
            throw new UnknownInstanceStateObtainedException(String.format("An unknown instance state: %s was obtained.", code));
        }
    }

    public InstanceStateCounter get() {
        return instanceStateCounter;
    }

    public enum State {
        PENDING(0),
        RUNNING(16),
        SHUTTING_DOWN(32),
        TERMINATED(48),
        STOPPING(64),
        STOPPED(80);

        private int state;

        State(int state) {
            this.state = state;
        }

        public int getState() {
            return state;
        }
    }

}
