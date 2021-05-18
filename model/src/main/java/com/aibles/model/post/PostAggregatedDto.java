package com.aibles.model.post;

import com.aibles.model.image.ImageDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonIgnoreProperties({"id"})
public class PostAggregatedDto extends PostDto{
    @JsonProperty
    @NonNull
    private List<ImageDto> images;

    public List<ImageDto> getImages() {
        return images;
    }

    public void setImages(List<ImageDto> images) {
        this.images = images;
    }


}
