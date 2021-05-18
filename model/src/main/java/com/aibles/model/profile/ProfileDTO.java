package com.aibles.model.profile;


import com.aibles.model.allow_user.AllowedUserDTO;
import com.aibles.model.blocked_user.BlockedUserDTO;
import com.aibles.model.email.EmailDTO;
import com.aibles.model.skill.SkillDTO;
import com.aibles.model.url.UrlDTO;
import com.aibles.model.work_history.WorkHistoryDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfileDTO {

    private String id;

    @JsonProperty("created_at")
    private Instant createdAt;

    @JsonProperty("updated_at")
    private Instant updatedAt;

    @JsonProperty("avatar_url")
    private String avatarUrl;

    @JsonProperty("cover_img_url")
    private String coverImgUrl;

    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("dob")
    private Date dob;

    @JsonProperty("phone_no")
    private String phoneNo;

    @JsonProperty("address")
    private String address;

    @JsonProperty("bio")
    private String bio;

    @JsonProperty("profile_url")
    private String profileUrl;

    @JsonProperty("job_title")
    private String jobTitle;

    @JsonProperty("privacy_profile")
    private String privacy;

    @JsonProperty("emails")
    private List<EmailDTO> emails;

    @JsonProperty("urls")
    private List<UrlDTO> urls;
    
    @JsonProperty("skills")
    private List<SkillDTO> skills;

    @JsonProperty("work_histories")
    private List<WorkHistoryDTO> workHistories;
    
    @JsonProperty("blocked_users")
    private List<BlockedUserDTO> blockedUsers;

    @JsonProperty("allowed_users")
    private List<AllowedUserDTO> allowedUsers;

}