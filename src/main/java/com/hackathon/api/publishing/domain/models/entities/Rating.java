package com.hackathon.api.publishing.domain.models.entities;

import com.hackathon.api.publishing.domain.models.aggregates.Post;
import com.hackathon.api.security.domain.models.entities.Citizen;
import com.hackathon.api.shared.domain.models.entities.BaseDomainModel;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "ratings")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rating extends BaseDomainModel {
    private int value;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "citizen_id")
    private Citizen citizen;
}
