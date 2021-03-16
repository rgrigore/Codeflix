package com.codecool.videorecommendation.controller;

import com.codecool.videorecommendation.model.RecommendationDTO;
import com.codecool.videorecommendation.model.RecommendationsDTO;
import com.codecool.videorecommendation.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recommendation")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RecommendationController {

    private final RecommendationService service;

    @GetMapping("/video/{videoId}")
    public RecommendationsDTO getRecommendations(@PathVariable Long videoId) {
        return new RecommendationsDTO(service.getRecommendationsForVideo(videoId));
    }

    @PostMapping("/add")
    public void addRecommendation(@RequestBody RecommendationDTO recommendationDTO) {
        service.addRecommendation(
                recommendationDTO.getVideoId(),
                recommendationDTO.getRating(),
                recommendationDTO.getComment()
        );
    }
}
