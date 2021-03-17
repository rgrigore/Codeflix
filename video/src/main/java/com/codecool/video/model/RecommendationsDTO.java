package com.codecool.video.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class RecommendationsDTO {
    private List<Recommendation> recommendations;
}
