package com.hackathon.api.publishing.application.features;

import com.hackathon.api.publishing.domain.models.queries.GetAllTagsQuery;
import com.hackathon.api.publishing.domain.models.responses.TagResponse;
import com.hackathon.api.publishing.domain.services.ITagQueryService;
import com.hackathon.api.publishing.infrastructure.persistence.repositories.ITagRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagQueryService implements ITagQueryService {
    @Autowired
    private ITagRepository tagRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<TagResponse> handle(GetAllTagsQuery query) {
        var tagList = tagRepository.findAll();

        return tagList.stream()
                .map(tag -> mapper.map(tag, TagResponse.class))
                .collect(Collectors.toList());
    }
}
