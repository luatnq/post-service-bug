package com.aibles.model.user;

public class UserAccountRoleDto {

    private Long id;
    private Long roleId;
    private Long userAccountId;

    public UserAccountRoleDto() {
    }

    public UserAccountRoleDto(Builder builder) {
        this.id = builder.id;
        this.roleId = builder.roleId;
        this.userAccountId = builder.userAccountId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(Long userAccountId) {
        this.userAccountId = userAccountId;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private Long roleId;
        private Long userAccountId;

        public Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder roleId(Long roleId) {
            this.roleId = roleId;
            return this;
        }

        public Builder userAccountId(Long userAccountId) {
            this.userAccountId = userAccountId;
            return this;
        }

        public UserAccountRoleDto build() {
            return new UserAccountRoleDto(this);
        }
    }

    @Override
    public String toString() {
        return "UserAccountRoleDto{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", userAccountId=" + userAccountId +
                '}';
    }
}
