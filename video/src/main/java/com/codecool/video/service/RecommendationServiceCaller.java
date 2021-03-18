package com.codecool.video.service;

import com.codecool.video.model.AddRecommendationDTO;
import com.codecool.video.model.Recommendation;
import com.codecool.video.model.RecommendationsDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RecommendationServiceCaller {

    private final RestTemplate restTemplate;

    @Value("${videorecommendation.url}")
    private String baseUrl;

    public List<Recommendation> getRecommendationsForVideo(Long id) {
        Optional<RecommendationsDTO> resp = Optional.ofNullable(restTemplate.getForObject(baseUrl + "/video/" + id, RecommendationsDTO.class));
        return resp.map(RecommendationsDTO::getRecommendations).orElse(new ArrayList<>());
    }

    public void add(AddRecommendationDTO recommendation, Long videoId) {
        restTemplate.postForEntity(baseUrl + "/add", recommendation.setVideoId(videoId), ResponseEntity.class);
    }

    public void delete(Long id) {
        restTemplate.delete(baseUrl + "/delete/" + id);
    }

    public void deleteForVideo(Long id) {
        getRecommendationsForVideo(id).stream().map(Recommendation::getId).forEach(this::delete);
    }
}
