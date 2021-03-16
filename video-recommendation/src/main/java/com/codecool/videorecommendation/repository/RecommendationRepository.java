package com.codecool.videorecommendation.repository;

import com.codecool.videorecommendation.model.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {
    List<Recommendation> findAllByVideoId(Long videoId);
}
