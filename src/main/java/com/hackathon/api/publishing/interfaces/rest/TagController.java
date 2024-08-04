package com.hackathon.api.publishing.interfaces.rest;

import com.hackathon.api.publishing.domain.models.queries.GetAllTagsQuery;
import com.hackathon.api.publishing.domain.models.responses.TagResponse;
import com.hackathon.api.publishing.domain.services.ITagQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/tags")
@CrossOrigin(origins = "*")
public class TagController {
    @Autowired
    private ITagQueryService tagQueryService;

    @GetMapping
    public ResponseEntity<List<TagResponse>> getAllTags() {
        var query = new GetAllTagsQuery();
        var tags = tagQueryService.handle(query);
        return ResponseEntity.ok(tags);
    }
}
