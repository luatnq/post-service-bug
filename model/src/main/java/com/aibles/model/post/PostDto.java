package com.aibles.model.post;


import com.aibles.model.previewLink.PreviewLinkDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@Data
public class PostDto implements Serializable {

    private static final long serialVersionUID = -2359346188693021596L;

    private int id;

    @JsonProperty("uid")
    private String uId;

    @JsonProperty("caption")
    private String caption;

    @JsonProperty("hashtag")
    private String hashtag;

    @JsonProperty("share_count")
    private int shareCount;

    @JsonProperty("comment_count")
    private int commentCount;

    @JsonProperty("view_count")
    private int viewCount;

    @JsonProperty("react_count")
    private int reactCount;

    @JsonProperty("feeling")
    private String feeling;

    @JsonProperty("share_caption")
    private String shareCaption;

    @JsonProperty("hyper_link")
    private String hyperLink;

    @JsonProperty("topic")
    private String topic;

    @JsonProperty("created_at")
    private Instant createdAt;

    @JsonProperty("updated_at")
    private Instant updatedAt;

    @JsonProperty("contain_images")
    private boolean containImages;
    public boolean getContainImages() {
        return containImages;
    }
}
