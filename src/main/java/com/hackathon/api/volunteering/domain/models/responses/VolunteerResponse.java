package com.hackathon.api.volunteering.domain.models.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VolunteerResponse {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime dateTime;
    private String location;
    private String requirements;
}
