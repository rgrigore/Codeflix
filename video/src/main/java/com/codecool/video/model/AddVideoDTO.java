package com.codecool.video.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddVideoDTO {
    private String title;
    private String url;
}
