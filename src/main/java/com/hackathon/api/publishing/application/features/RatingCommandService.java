package com.hackathon.api.publishing.application.features;

import com.hackathon.api.publishing.domain.models.commands.CreateRatingCommand;
import com.hackathon.api.publishing.domain.models.entities.Rating;
import com.hackathon.api.publishing.domain.services.IRatingCommandService;
import com.hackathon.api.publishing.infrastructure.persistence.repositories.IPostRepository;
import com.hackathon.api.publishing.infrastructure.persistence.repositories.IRatingRepository;
import com.hackathon.api.security.infrastructure.persistence.repositories.ICitizenRepository;
import com.hackathon.api.shared.application.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingCommandService implements IRatingCommandService {
    @Autowired
    private IRatingRepository ratingRepository;

    @Autowired
    private ICitizenRepository citizenRepository;

    @Autowired
    private IPostRepository postRepository;

    @Override
    public void createRating(CreateRatingCommand command) {
        var rating = new Rating();

        rating.setValue(command.getValue());

        var post = postRepository.findById(command.getPostId()).orElseThrow(
            () -> new NotFoundException("Post not found")
        );

        rating.setPost(post);

        var citizen = citizenRepository.findById(command.getCitizenId()).orElseThrow(
            () -> new NotFoundException("Citizen not found")
        );

        rating.setCitizen(citizen);

        ratingRepository.save(rating);

        post.setTotalRating(post.getTotalRating() + command.getValue());

        postRepository.save(post);
    }
}
