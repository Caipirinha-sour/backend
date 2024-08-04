package com.hackathon.api.volunteering.domain.models.aggregates;

import com.hackathon.api.shared.domain.models.entities.BaseDomainModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "volunteers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Volunteer extends BaseDomainModel {
    private String name;
    private String description;
    private LocalDateTime dateTime;
    private String location;
    private String requirements;
}