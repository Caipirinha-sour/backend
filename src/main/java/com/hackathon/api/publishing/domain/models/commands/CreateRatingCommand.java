package com.hackathon.api.publishing.domain.models.commands;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRatingCommand {
    @NotEmpty(message = "Value is required")
    @Range(min = -1, max = 1, message = "Value must be between 1 and 5")
    private int value;

    @NotEmpty(message = "Post ID is required")
    @Range(min = 1, message = "Post ID must be a positive integer")
    private Long postId;

    @NotEmpty(message = "Citizen ID is required")
    @Range(min = 1, message = "Citizen ID must be a positive integer")
    private Long citizenId;
}
