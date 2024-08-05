package com.hackathon.api.volunteering.domain.services;

import com.hackathon.api.volunteering.domain.models.queries.GetAllVolunteersQuery;
import com.hackathon.api.volunteering.domain.models.queries.GetVolunteerByIdQuery;
import com.hackathon.api.volunteering.domain.models.responses.VolunteerResponse;

import java.util.List;

public interface IVolunteerQueryService {
    VolunteerResponse getVolunteerById(GetVolunteerByIdQuery query);
    List<VolunteerResponse> getAllVolunteers(GetAllVolunteersQuery query);
}
