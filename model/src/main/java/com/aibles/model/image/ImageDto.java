package com.aibles.model.image;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageDto implements Serializable {

    private Long id;

    private String uuid;

    @JsonProperty("image_format")
    private String imageFormat;

    private String caption;

    private int width;

    private int height;

    @JsonProperty("created_by")
    private String createdBy;

    @JsonProperty("created_date")
    private Instant createdDate;

    @JsonProperty("updated_by")
    private String updatedBy;

    @JsonProperty("updated_date")
    private Instant updatedDate;

    @JsonProperty("image_thumb")
    private String imageThumb;

    @JsonProperty("image_default")
    private String imageDefault;

    private Long size;

    @JsonProperty("post_id")
    private int postId;
}
