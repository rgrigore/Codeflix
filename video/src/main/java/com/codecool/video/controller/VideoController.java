package com.codecool.video.controller;

import com.codecool.video.model.*;
import com.codecool.video.service.RecommendationServiceCaller;
import com.codecool.video.service.VideoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/videos")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class VideoController {

    private final VideoService videoService;
    private final RecommendationServiceCaller recommendationServiceCaller;

    @GetMapping("/all")
    public VideosListDTO getAllVideos() {
        return new VideosListDTO(videoService.getAll());
    }

    @GetMapping("/{id}")
    public VideoDTO getVideo(@PathVariable Long id) {
        return videoService.getVideoDTO(id);
    }

    @PostMapping("/add")
    public void addVideo(@RequestBody AddVideoDTO video) {
        videoService.add(video.getTitle(), video.getUrl());
    }

    @DeleteMapping("/{id}/delete")
    public void deleteVideo(@PathVariable Long id) {
        videoService.delete(id);
    }

    @PostMapping("/{videoId}/recommendation/add")
    public void addRecommendation(@PathVariable Long videoId, @RequestBody AddRecommendationDTO recommendation) {
        recommendationServiceCaller.add(recommendation, videoId);
    }

    @DeleteMapping("/recommendation/{id}/delete")
    public void deleteRecommendation(@PathVariable Long id) {
        recommendationServiceCaller.delete(id);
    }
}
