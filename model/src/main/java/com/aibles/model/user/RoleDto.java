package com.aibles.model.user;

public class RoleDto {
    private Long id;
    private String roleName;

    public RoleDto() {
    }

    public RoleDto(Builder builder) {
        this.id = builder.id;
        this.roleName = builder.roleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String roleName;

        public Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder roleName(String roleName) {
            this.roleName = roleName;
            return this;
        }

        public RoleDto build() {
            return new RoleDto(this);
        }
    }

    @Override
    public String toString() {
        return "RoleDto{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
