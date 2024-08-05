package com.hackathon.api.publishing.domain.services;

import com.hackathon.api.publishing.domain.models.commands.CreateRatingCommand;

public interface IRatingCommandService {
    void createRating(CreateRatingCommand command);
}
