package com.hackathon.api.publishing.domain.services;

import com.hackathon.api.publishing.domain.models.queries.GetAllPostsQuery;
import com.hackathon.api.publishing.domain.models.queries.GetPostByIdQuery;
import com.hackathon.api.publishing.domain.models.queries.GetPostsByCitizenIdQuery;
import com.hackathon.api.publishing.domain.models.queries.GetPostsByTagIdQuery;
import com.hackathon.api.publishing.domain.models.responses.PostResponse;

import java.util.List;

public interface IPostQueryService {
    List<PostResponse> handle(GetAllPostsQuery query);
    PostResponse handle(GetPostByIdQuery query);
    List<PostResponse> handle(GetPostsByTagIdQuery query);
    List<PostResponse> handle(GetPostsByCitizenIdQuery query);
}
