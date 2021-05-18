package com.aibles.model.url;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UrlDTO {

    private String id;

    @JsonProperty("created_at")
    private Instant createdAt;

    @JsonProperty("updated_at")
    private Instant updatedAt;

    @JsonProperty("url_link")
    private String urlLink;

    @JsonProperty("platform")
    private String platForm;

    @JsonProperty("privacy_url")
    private String privacyUrl;

    @JsonProperty("profile_id")
    private String profileId;

}
