package com.ecommerce.user.model;

public class UserLoginResponse {
    private boolean success;
    private UserLoginFailedReason reason;

    public UserLoginResponse() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public UserLoginFailedReason getReason() {
        return reason;
    }

    public void setReason(UserLoginFailedReason reason) {
        this.reason = reason;
    }
}
