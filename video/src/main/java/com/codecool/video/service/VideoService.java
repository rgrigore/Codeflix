package com.codecool.video.service;

import com.codecool.video.model.Video;
import com.codecool.video.repository.VideoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class VideoService {
    private final VideoRepository videoRepository;

    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    public Video getVideo(Long id) {
        Video video = Video.builder().id(null).name("").url("").build();
        videoRepository.findById(id).ifPresent(v -> {video.setId(v.getId()); video.setName(v.getName()); video.setUrl(v.getUrl());});
        return video;
    }

    //Test data
//    @PostConstruct
//    public void afterInit() {
//        List<String> urls = new ArrayList<>();
//        urls.add("h9PKIgpb2Bs");
//        urls.add("jTN_IYDKTiE");
//        urls.add("fzBDw279rJQ");
//        urls.add("KOcAxiYwryY");
//        for(int i = 1; i < 5; i++) {
//            Video video = Video.builder().name("Video " + i).url(urls.get(i-1)).build();
//            videoRepository.save(video);
//        }
//    }
}
