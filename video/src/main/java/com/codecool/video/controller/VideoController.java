package com.codecool.video.controller;

import com.codecool.video.model.Video;
import com.codecool.video.service.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping("/all")
    public List<Video> getAllVideos() {
        return videoService.getAllVideos();
    }

}
