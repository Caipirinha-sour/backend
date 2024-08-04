package com.hackathon.api.volunteering.domain.models.entities;

import com.hackathon.api.security.domain.models.entities.Citizen;
import com.hackathon.api.shared.domain.models.entities.BaseDomainModel;
import com.hackathon.api.volunteering.domain.models.aggregates.Volunteer;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "registration_citizens")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationCitizen extends BaseDomainModel {
    @ManyToOne
    @JoinColumn(name = "volunteer_id")
    private Volunteer volunteer;

    @ManyToOne
    @JoinColumn(name = "citizen_id")
    private Citizen citizen;
}
