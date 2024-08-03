package com.hackathon.api.publishing.domain.services;

import com.hackathon.api.publishing.domain.models.commands.CreatePostCommand;
import com.hackathon.api.publishing.domain.models.responses.PostResponse;

public interface IPostCommandService {
    PostResponse handle(CreatePostCommand command);
}
