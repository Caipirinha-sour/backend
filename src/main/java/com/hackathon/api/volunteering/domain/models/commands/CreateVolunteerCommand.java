package com.hackathon.api.volunteering.domain.models.commands;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateVolunteerCommand {
    @NotEmpty(message = "Name is required")
    @Size(min = 3, max = 32, message = "Name must be between 3 and 32 characters")
    private String name;

    @NotEmpty(message = "Description is required")
    @Size(min = 3, max = 256, message = "Description must be between 3 and 256 characters")
    private String description;

    @Future(message = "Date and time must be in the future")
    private LocalDateTime dateTime;

    @NotEmpty(message = "Location is required")
    @Size(min = 3, max = 64, message = "Location must be between 3 and 64 characters")
    private String location;

    @NotEmpty(message = "Requirements are required")
    @Size(min = 3, max = 256, message = "Requirements must be between 3 and 256 characters")
    private String requirements;

}
