package com.codecool.videorecommendation.controller;

import com.codecool.videorecommendation.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recommendation")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RecommendationController {

    private final RecommendationService service;
}
