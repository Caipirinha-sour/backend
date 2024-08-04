package com.hackathon.api.volunteering.application.features;

import com.hackathon.api.security.infrastructure.persistence.repositories.ICitizenRepository;
import com.hackathon.api.shared.application.exceptions.NotFoundException;
import com.hackathon.api.volunteering.domain.models.aggregates.Volunteer;
import com.hackathon.api.volunteering.domain.models.commands.CreateRegistrationCitizenCommand;
import com.hackathon.api.volunteering.domain.models.commands.CreateVolunteerCommand;
import com.hackathon.api.volunteering.domain.models.entities.RegistrationCitizen;
import com.hackathon.api.volunteering.domain.models.responses.VolunteerResponse;
import com.hackathon.api.volunteering.domain.services.IVolunteerCommandService;
import com.hackathon.api.volunteering.infrastructure.persistence.repositories.IRegistrationCitizenRepository;
import com.hackathon.api.volunteering.infrastructure.persistence.repositories.IVolunteerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VolunteerCommandService implements IVolunteerCommandService {
    @Autowired
    private IVolunteerRepository volunteerRepository;

    @Autowired
    private ICitizenRepository citizenRepository;

    @Autowired
    private IRegistrationCitizenRepository registrationCitizenRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public VolunteerResponse createVolunteer(CreateVolunteerCommand command) {
        var volunteer = mapper.map(command, Volunteer.class);

        var newVolunteer = volunteerRepository.save(volunteer);

        return mapper.map(newVolunteer, VolunteerResponse.class);
    }

    @Override
    public void createRegistrationCitizen(CreateRegistrationCitizenCommand command) {
        var registration = new RegistrationCitizen();

        var volunteer = volunteerRepository.findById(command.getVolunteerId()).orElseThrow(
                () -> new NotFoundException("Volunteer not found")
        );

        registration.setVolunteer(volunteer);

        var citizen = citizenRepository.findById(command.getCitizenId()).orElseThrow(
                () -> new NotFoundException("Citizen not found")
        );

        registration.setCitizen(citizen);

        registrationCitizenRepository.save(registration);
    }
}
