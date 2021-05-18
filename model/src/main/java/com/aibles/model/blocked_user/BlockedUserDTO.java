package com.aibles.model.blocked_user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BlockedUserDTO {

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("blocked_user_id")
    private String blockedUserId;

    @JsonProperty("name_user_blocked")
    private String nameBlockedUser;

}
