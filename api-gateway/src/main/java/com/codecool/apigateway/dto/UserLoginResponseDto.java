package com.codecool.apigateway.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginResponseDto {
    private Long id;
    private String username;
    private List<String> roles = new ArrayList<>();
    private String token;
}
