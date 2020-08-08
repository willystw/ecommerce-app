package com.ecommerce.user.model;

import com.ecommerce.user.entity.UserType;

import javax.validation.constraints.NotBlank;

public class UserLoginRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private UserType deviceInterface;

    public UserLoginRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getDeviceInterface() {
        return deviceInterface;
    }

    public void setDeviceInterface(UserType deviceInterface) {
        this.deviceInterface = deviceInterface;
    }
}
