package com.codecool.video;

import com.codecool.video.model.Video;
import com.codecool.video.service.VideoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
class VideoServiceTest {

    @Autowired
    private VideoService videoService;

    @Test
    public void getAllVideos() {
        assertEquals(4, videoService.getAllVideos().size());
    }

    @Test
    public void getVideoById() {
        Video video = Video.builder().id(1L).name("Video 1").url("https://www.youtube.com/watch?v=h9PKIgpb2Bs").build();
        assertThat(videoService.getVideo(1L)).isEqualTo(video);
    }
}