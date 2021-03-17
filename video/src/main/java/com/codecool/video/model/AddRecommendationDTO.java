package com.codecool.video.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddRecommendationDTO {
    private int rating;
    private String comment;
    private Long videoId;

    public AddRecommendationDTO setVideoId(Long videoId) {
        this.videoId = videoId;
        return this;
    }
}
