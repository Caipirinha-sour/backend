package com.hackathon.api.volunteering.application.features;

import com.hackathon.api.shared.application.exceptions.NotFoundException;
import com.hackathon.api.volunteering.domain.models.queries.GetAllVolunteersQuery;
import com.hackathon.api.volunteering.domain.models.queries.GetVolunteerByIdQuery;
import com.hackathon.api.volunteering.domain.models.responses.VolunteerResponse;
import com.hackathon.api.volunteering.domain.services.IVolunteerQueryService;
import com.hackathon.api.volunteering.infrastructure.persistence.repositories.IVolunteerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VolunteerQueryService implements IVolunteerQueryService {
    @Autowired
    private IVolunteerRepository volunteerRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public VolunteerResponse getVolunteerById(GetVolunteerByIdQuery query) {
        var volunteer = volunteerRepository.findById(query.id()).orElseThrow(
            () -> new NotFoundException("Volunteer not found")
        );

        return mapper.map(volunteer, VolunteerResponse.class);
    }

    @Override
    public List<VolunteerResponse> getAllVolunteers(GetAllVolunteersQuery query) {
        var volunteers = volunteerRepository.findAll();

        return volunteers.stream()
                .map(volunteer -> mapper.map(volunteer, VolunteerResponse.class))
                .collect(Collectors.toList());
    }
}
