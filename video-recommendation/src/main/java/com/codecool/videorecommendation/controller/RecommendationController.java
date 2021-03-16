package com.codecool.videorecommendation.controller;

import com.codecool.videorecommendation.model.RecommendationsDTO;
import com.codecool.videorecommendation.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recommendation")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RecommendationController {

    private final RecommendationService service;

    @GetMapping("/video/{videoId}")
    public RecommendationsDTO getRecommendations(@PathVariable Long videoId) {
        return new RecommendationsDTO(service.getRecommendationsForVideo(videoId));
    }
}
