package com.hackathon.api.security.domain.models.entities;

import com.hackathon.api.shared.domain.models.entities.BaseDomainModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "organizations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Organization extends BaseDomainModel {
    private String username;
    private String password;
    private String email;
    private String profileImage;
    private String description;
    private String contact;
}
