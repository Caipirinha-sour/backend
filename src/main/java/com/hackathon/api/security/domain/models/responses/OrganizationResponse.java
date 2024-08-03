package com.hackathon.api.security.domain.models.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationResponse {
    private Long Id;
    private String username;
    private String profileImage;
    private String description;
    private String contact;
}
