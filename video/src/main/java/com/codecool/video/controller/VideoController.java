package com.codecool.video.controller;

import com.codecool.video.model.AddRecommendationDTO;
import com.codecool.video.model.Video;
import com.codecool.video.model.VideoRecommendationDTO;
import com.codecool.video.service.RecommendationServiceCaller;
import com.codecool.video.service.VideoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class VideoController {

    private final VideoService videoService;
    private final RecommendationServiceCaller recommendationServiceCaller;

    @GetMapping("/all")
    public List<Video> getAllVideos() {
        return videoService.getAllVideos();
    }

    @GetMapping("/{id}")
    public Video getVideo(@PathVariable String id) {
        return videoService.getVideo(Long.parseLong(id));
    }

    @GetMapping("/{id}/recommendations")
    public List<VideoRecommendationDTO> getRecommendations(@PathVariable String id) {
        return recommendationServiceCaller.getRecommendationsForVideo(Long.parseLong(id)).getRecommendations();
    }

    @PostMapping("/{id}/addrecommendation")
    public void addRecommendation(@PathVariable String id, @RequestBody AddRecommendationDTO recommendation) {
        log.info("adding recommendation for Q " + id);
        recommendationServiceCaller.addRecommendation(recommendation);
    }

    @DeleteMapping("/deleterecommendation/{id}")
    public void deleteRecommendation(@PathVariable String id) {
        recommendationServiceCaller.deleteRecommendation(Long.parseLong(id));
    }
}
