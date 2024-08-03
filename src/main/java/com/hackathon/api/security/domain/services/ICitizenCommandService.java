package com.hackathon.api.security.domain.services;

import com.hackathon.api.security.domain.models.commands.CreateCitizenCommand;
import com.hackathon.api.security.domain.models.responses.CitizenResponse;

public interface ICitizenCommandService {
    CitizenResponse handle(CreateCitizenCommand command);
}
