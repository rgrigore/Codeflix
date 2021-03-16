package com.codecool.video.service;

import com.codecool.video.model.AddRecommendationDTO;
import com.codecool.video.model.VideoRecommendationDTO;
import com.codecool.video.model.VideoRecommendationsDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RecommendationServiceCaller {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${videorecommendation.url}")
    private String baseUrl;

    public VideoRecommendationsDTO getRecommendationsForVideo(Long id) {
        ResponseEntity<VideoRecommendationsDTO> resp = restTemplate.getForEntity(baseUrl + "/video/" + id, VideoRecommendationsDTO.class);
        VideoRecommendationsDTO recommendations = resp.getBody();
        assert recommendations != null;
        log.info("Got rec. for Q " + id + " ==" + recommendations.getRecommendations().toString());
        return recommendations;
    }

    public void addRecommendation(AddRecommendationDTO recommendation) {
        log.info("Add new rec. " + recommendation.toString());
        restTemplate.postForEntity(baseUrl + "/add", recommendation, ResponseEntity.class);
    }

    public void deleteRecommendation(Long id) {
        log.info("Delete rec. " + id);
        restTemplate.delete(baseUrl + "/delete/" + id);
    }
}
