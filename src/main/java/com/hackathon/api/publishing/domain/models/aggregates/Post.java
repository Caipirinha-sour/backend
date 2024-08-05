package com.hackathon.api.publishing.domain.models.aggregates;

import com.hackathon.api.publishing.domain.models.entities.Tag;
import com.hackathon.api.security.domain.models.entities.Citizen;
import com.hackathon.api.shared.domain.models.entities.BaseDomainModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "posts")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post extends BaseDomainModel {
    private String text;
    private String mediaUrl;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

    @ManyToOne
    @JoinColumn(name = "citizen_id")
    private Citizen citizen;

    private int totalRating = 0;
}
