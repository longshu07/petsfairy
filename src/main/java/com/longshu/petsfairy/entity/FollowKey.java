package com.longshu.petsfairy.entity;

public class FollowKey {
    private String customerId;

    private String followedCustomer;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    public String getFollowedCustomer() {
        return followedCustomer;
    }

    public void setFollowedCustomer(String followedCustomer) {
        this.followedCustomer = followedCustomer == null ? null : followedCustomer.trim();
    }
}