package com.codecool.videorecommendation.service;

import com.codecool.videorecommendation.model.Recommendation;
import com.codecool.videorecommendation.repository.RecommendationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RecommendationService {

    private final RecommendationRepository repository;

    public List<Recommendation> getForVideo(Long videoId) {
        return repository.findAllByVideoId(videoId);
    }

    public void add(Long videoId, int rating, String comment) {
        repository.save(Recommendation.builder()
                .videoId(videoId)
                .rating(rating)
                .comment(comment)
                .build()
        );
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
