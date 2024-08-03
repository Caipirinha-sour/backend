package com.hackathon.api.publishing.interfaces.rest;

import com.hackathon.api.publishing.domain.models.commands.CreateRatingCommand;
import com.hackathon.api.publishing.domain.services.IRatingCommandService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/ratings")
public class RatingController {
    @Autowired
    private IRatingCommandService ratingQueryService;

    @PostMapping
    public ResponseEntity<?> createRating(
            @Valid @RequestBody CreateRatingCommand command
    )
    {
        ratingQueryService.createRating(command);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
