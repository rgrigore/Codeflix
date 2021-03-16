package com.codecool.video.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class VideoRecommendationsDTO {
    private List<VideoRecommendationDTO> recommendations;

    public VideoRecommendationsDTO() {
        this.recommendations = new ArrayList<>();
    }
}
