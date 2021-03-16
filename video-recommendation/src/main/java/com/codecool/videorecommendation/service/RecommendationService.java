package com.codecool.videorecommendation.service;

import com.codecool.videorecommendation.repository.RecommendationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RecommendationService {

    private final RecommendationRepository repository;

}
