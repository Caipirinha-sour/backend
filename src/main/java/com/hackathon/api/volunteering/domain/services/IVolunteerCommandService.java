package com.hackathon.api.volunteering.domain.services;

import com.hackathon.api.volunteering.domain.models.commands.CreateRegistrationCitizenCommand;
import com.hackathon.api.volunteering.domain.models.commands.CreateVolunteerCommand;
import com.hackathon.api.volunteering.domain.models.responses.VolunteerResponse;

public interface IVolunteerCommandService {
    VolunteerResponse createVolunteer(CreateVolunteerCommand command);
    void createRegistrationCitizen(CreateRegistrationCitizenCommand command);
}
