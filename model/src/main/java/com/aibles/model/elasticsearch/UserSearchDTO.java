package com.aibles.model.elasticsearch;

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
public class UserSearchDTO {

    private String uid;

    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("dob")
    private String dob;

    @JsonProperty("address")
    private String address;

    @JsonProperty("job_title")
    private String jobTitle;

    @JsonProperty("privacy")
    private String privacy;
}
