package com.codecool.video.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddRecommendationDTO {
    private String rating;
    private String comment;
    private String videoId;
}
