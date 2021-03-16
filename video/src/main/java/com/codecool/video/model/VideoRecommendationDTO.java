package com.codecool.video.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VideoRecommendationDTO {
    private Long id;
    private int rating;
    private String comment;
    private Long videoId;
}
