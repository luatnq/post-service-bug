package com.aibles.model.allow_user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AllowedUserDTO {
    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("allowed_user_id")
    private String allowedUserId;

    @JsonProperty("name_user_allowed")
    private String nameAllowedUser;
}
