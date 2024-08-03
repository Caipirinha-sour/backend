package com.hackathon.api.publishing.interfaces.rest;

import com.hackathon.api.publishing.domain.models.commands.CreatePostCommand;
import com.hackathon.api.publishing.domain.models.queries.GetAllPostsQuery;
import com.hackathon.api.publishing.domain.models.queries.GetPostByIdQuery;
import com.hackathon.api.publishing.domain.models.queries.GetPostsByTagIdQuery;
import com.hackathon.api.publishing.domain.models.responses.PostResponse;
import com.hackathon.api.publishing.domain.services.IPostCommandService;
import com.hackathon.api.publishing.domain.services.IPostQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/posts")
public class PostController {
    @Autowired
    private IPostQueryService postQueryService;

    @Autowired
    private IPostCommandService postCommandService;

    @GetMapping
    public ResponseEntity<List<PostResponse>> getAllPosts() {
        var query = new GetAllPostsQuery();
        var posts = postQueryService.handle(query);
        return ResponseEntity.ok(posts);
    }

    @GetMapping("{id}")
    public ResponseEntity<PostResponse> getPostById(@PathVariable Long id) {
        var query = new GetPostByIdQuery(id);
        var post = postQueryService.handle(query);
        return ResponseEntity.ok(post);
    }

    @GetMapping("/tag/{tagId}")
    public ResponseEntity<List<PostResponse>> getPostsByTagId(@PathVariable Long tagId) {
        var query = new GetPostsByTagIdQuery(tagId);
        var posts = postQueryService.handle(query);
        return ResponseEntity.ok(posts);
    }

    @PostMapping
    public ResponseEntity<PostResponse> createPost(
            @RequestBody CreatePostCommand command
    )
    {
        var postResponse = postCommandService.handle(command);
        return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
    }

}
