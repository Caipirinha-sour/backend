package com.hackathon.api.publishing.domain.models.commands;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePostCommand {
    @NotEmpty(message = "Title may not be empty")
    @Size(min=0, max=255, message = "Title must be between 0 and 255 characters long")
    private String text;

    private String mediaUrl;

    @Positive(message = "Tag ID must be a positive integer")
    private Long tagId;

    @Positive(message = "Citizen ID must be a positive integer")
    private Long citizenId;
}
