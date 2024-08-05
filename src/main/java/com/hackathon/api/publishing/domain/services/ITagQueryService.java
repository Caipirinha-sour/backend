package com.hackathon.api.publishing.domain.services;

import com.hackathon.api.publishing.domain.models.queries.GetAllTagsQuery;
import com.hackathon.api.publishing.domain.models.responses.TagResponse;

import java.util.List;

public interface ITagQueryService {
    List<TagResponse> handle(GetAllTagsQuery query);
}
