package com.codecool.videorecommendation.model;

import lombok.Data;

import java.util.List;

@Data
public class RecommendationsDTO {
    private List<Recommendation> recommendations;

    public RecommendationsDTO(List<Recommendation> recommendations) {
        this.recommendations = recommendations;
    }
}
