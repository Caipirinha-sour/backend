package com.hackathon.api.publishing.application.features;

import com.hackathon.api.publishing.domain.models.queries.GetAllPostsQuery;
import com.hackathon.api.publishing.domain.models.queries.GetPostByIdQuery;
import com.hackathon.api.publishing.domain.models.queries.GetPostsByCitizenIdQuery;
import com.hackathon.api.publishing.domain.models.queries.GetPostsByTagIdQuery;
import com.hackathon.api.publishing.domain.models.responses.PostResponse;
import com.hackathon.api.publishing.domain.services.IPostQueryService;
import com.hackathon.api.publishing.infrastructure.persistence.repositories.IPostRepository;
import com.hackathon.api.publishing.infrastructure.persistence.repositories.ITagRepository;
import com.hackathon.api.security.infrastructure.persistence.repositories.ICitizenRepository;
import com.hackathon.api.shared.application.exceptions.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostQueryService implements IPostQueryService {
    @Autowired
    private IPostRepository postRepository;

    @Autowired
    private ITagRepository tagRepository;

    @Autowired
    private ICitizenRepository citizenRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<PostResponse> handle(GetAllPostsQuery query) {
        var postList = postRepository.findAll();

        return postList.stream()
                .map(post -> mapper.map(post, PostResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostResponse handle(GetPostByIdQuery query) {
        var postEntity = postRepository.findById(query.postId())
                .orElseThrow(() -> new NotFoundException("Post not found"));

        return mapper.map(postEntity, PostResponse.class);
    }

    @Override
    public List<PostResponse> handle(GetPostsByTagIdQuery query) {
        var tagFound = tagRepository.findById(query.tagId()).orElseThrow(
                () -> new NotFoundException("Tag not found")
        );

        var postList = postRepository.findByTagId(tagFound.getId());

        return postList.stream()
                .map(post -> mapper.map(post, PostResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PostResponse> handle(GetPostsByCitizenIdQuery query) {
        var citizenFound = citizenRepository.findById(query.citizenId()).orElseThrow(
                () -> new NotFoundException("Citizen not found")
        );

        var postList = postRepository.findByCitizenId(citizenFound.getId());

        return postList.stream()
                .map(post -> mapper.map(post, PostResponse.class))
                .collect(Collectors.toList());
    }
}
