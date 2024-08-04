package com.hackathon.api.volunteering.application.features;

import com.hackathon.api.volunteering.domain.models.aggregates.Volunteer;
import com.hackathon.api.volunteering.domain.models.commands.CreateVolunteerCommand;
import com.hackathon.api.volunteering.domain.models.responses.VolunteerResponse;
import com.hackathon.api.volunteering.domain.services.IVolunteerCommandService;
import com.hackathon.api.volunteering.infrastructure.persistence.repositories.IVolunteerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VolunteerCommandService implements IVolunteerCommandService {
    @Autowired
    private IVolunteerRepository volunteerRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public VolunteerResponse createVolunteer(CreateVolunteerCommand command) {
        var volunteer = mapper.map(command, Volunteer.class);

        var newVolunteer = volunteerRepository.save(volunteer);

        return mapper.map(newVolunteer, VolunteerResponse.class);
    }
}
