package com.hackathon.api.publishing.domain.models.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagResponse {
    private Long id;
    private String name;
}
