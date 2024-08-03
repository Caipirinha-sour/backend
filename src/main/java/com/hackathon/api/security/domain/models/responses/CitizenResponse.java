package com.hackathon.api.security.domain.models.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CitizenResponse {
    private Long Id;
    private String username;
    private String profileImage;
}
