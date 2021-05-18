package com.aibles.model.user;

import java.time.Instant;

public class LoginSessionDto {

    private Long id;
    private int expiredTime;
    private Instant loginTime;
    private String loginAddress;
    private double loginLatitude;
    private double loginLongitude;
    private String loginDevice;
    private String loginOS;
    private String loginId;
    private Long userAccountRoleId;

    //loginsession

    public LoginSessionDto() {
    }

    public LoginSessionDto(Builder builder) {
        this.id = builder.id;
        this.expiredTime = builder.expiredTime;
        this.loginTime = builder.loginTime;
        this.loginAddress = builder.loginAddress;
        this.loginLatitude = builder.loginLatitude;
        this.loginLongitude = builder.loginLongitude;
        this.loginDevice = builder.loginDevice;
        this.loginOS = builder.loginOS;
        this.loginId = builder.loginId;
        this.userAccountRoleId = builder.userAccountRoleId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(int expiredTime) {
        this.expiredTime = expiredTime;
    }

    public Instant getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Instant loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginAddress() {
        return loginAddress;
    }

    public void setLoginAddress(String loginAddress) {
        this.loginAddress = loginAddress;
    }

    public double getLoginLatitude() {
        return loginLatitude;
    }

    public void setLoginLatitude(double loginLatitude) {
        this.loginLatitude = loginLatitude;
    }

    public double getLoginLongitude() {
        return loginLongitude;
    }

    public void setLoginLongitude(double loginLongitude) {
        this.loginLongitude = loginLongitude;
    }

    public String getLoginDevice() {
        return loginDevice;
    }

    public void setLoginDevice(String loginDevice) {
        this.loginDevice = loginDevice;
    }

    public String getLoginOS() {
        return loginOS;
    }

    public void setLoginOS(String loginOS) {
        this.loginOS = loginOS;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public Long getUserAccountRoleId() { return userAccountRoleId; }

    public void setUserAccountRoleId(Long userAccountRoleId) { this.userAccountRoleId = userAccountRoleId; }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private int expiredTime;
        private Instant loginTime;
        private String loginAddress;
        private double loginLatitude;
        private double loginLongitude;
        private String loginDevice;
        private String loginOS;
        private String loginId;
        private Long userAccountRoleId;

        public Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder expiredTime(int expiredTime) {
            this.expiredTime = expiredTime;
            return this;
        }

        public Builder loginTime(Instant loginTime) {
            this.loginTime = loginTime;
            return this;
        }

        public Builder loginAddress(String loginAddress) {
            this.loginAddress = loginAddress;
            return this;
        }

        public Builder loginLatitude(double loginLatitude) {
            this.loginLatitude = loginLatitude;
            return this;
        }

        public Builder loginLongitude(double loginLongitude) {
            this.loginLongitude = loginLongitude;
            return this;
        }

        public Builder loginDevice(String loginDevice) {
            this.loginDevice = loginDevice;
            return this;
        }

        public Builder loginOS(String loginOS) {
            this.loginOS = loginOS;
            return this;
        }

        public Builder loginId(String loginId) {
            this.loginId = loginId;
            return this;
        }

        public Builder userAccountRoleId(Long userAccountRoleId){
            this.userAccountRoleId = userAccountRoleId;
            return this;
        }

        public LoginSessionDto build() {
            return new LoginSessionDto(this);
        }
    }

    @Override
    public String toString() {
        return "LoginSessionDto{" +
                "id=" + id +
                ", expiredTime=" + expiredTime +
                ", loginTime=" + loginTime +
                ", loginAddress='" + loginAddress + '\'' +
                ", loginLatitude=" + loginLatitude +
                ", loginLongitude=" + loginLongitude +
                ", loginDevice='" + loginDevice + '\'' +
                ", loginOS='" + loginOS + '\'' +
                ", loginId='" + loginId + '\'' +
                ", userAccountRoleId='" + userAccountRoleId + '\'' +
                '}';
    }
}
