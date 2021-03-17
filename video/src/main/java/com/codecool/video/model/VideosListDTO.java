package com.codecool.video.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class VideosListDTO {
    private List<Video> videos;
}
