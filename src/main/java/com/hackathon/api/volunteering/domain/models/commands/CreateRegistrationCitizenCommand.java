package com.hackathon.api.volunteering.domain.models.commands;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRegistrationCitizenCommand {
    @Positive(message = "Volunteer ID must be a positive number")
    private Long volunteerId;

    @Positive(message = "Citizen ID must be a positive number")
    private Long citizenId;
}
