package com.hackathon.api.publishing.infrastructure.persistence.repositories;

import com.hackathon.api.publishing.domain.models.aggregates.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPostRepository extends JpaRepository<Post, Long> {
    List<Post> findByTagId(Long tagId);
}
