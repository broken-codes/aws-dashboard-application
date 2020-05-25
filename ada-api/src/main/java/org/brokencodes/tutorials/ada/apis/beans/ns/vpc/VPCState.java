package org.brokencodes.tutorials.ada.apis.beans.ns.vpc;

public enum VPCState {
    PENDING("pending"),
    AVAILABLE("available");

    private String state;

    VPCState(String state) {
        this.state = state;
    }
}
