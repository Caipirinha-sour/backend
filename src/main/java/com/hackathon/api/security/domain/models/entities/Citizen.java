package com.hackathon.api.security.domain.models.entities;

import com.hackathon.api.publishing.domain.models.aggregates.Post;
import com.hackathon.api.shared.domain.models.entities.BaseDomainModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "citizens")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Citizen extends BaseDomainModel {
    private String username;
    private String password;
    private String email;
    private String profileImage;
}
