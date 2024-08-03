package com.hackathon.api.publishing.application.features;

import com.hackathon.api.publishing.domain.models.aggregates.Post;
import com.hackathon.api.publishing.domain.models.commands.CreatePostCommand;
import com.hackathon.api.publishing.domain.models.responses.PostResponse;
import com.hackathon.api.publishing.domain.services.IPostCommandService;
import com.hackathon.api.publishing.infrastructure.persistence.repositories.IPostRepository;
import com.hackathon.api.publishing.infrastructure.persistence.repositories.ITagRepository;
import com.hackathon.api.shared.application.exceptions.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostCommandService implements IPostCommandService {
    @Autowired
    private IPostRepository postRepository;

    @Autowired
    private ITagRepository tagRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public PostResponse handle(CreatePostCommand command) {
        Post post = new Post();

        post.setText(command.getText());
        post.setMediaUrl(command.getMediaUrl());

        // Reglas del negocio
        var tagFound = tagRepository.findById(command.getTagId()).orElseThrow(
                () -> new NotFoundException("Tag not found"));

        post.setTag(tagFound);

        var newPost = postRepository.save(post);

        return mapper.map(newPost, PostResponse.class);
    }
}
