package com.hackathon.api.security.domain.services;

import com.hackathon.api.security.domain.models.queries.GetAllOrganizationsQuery;
import com.hackathon.api.security.domain.models.queries.GetOrganizationByIdQuery;
import com.hackathon.api.security.domain.models.responses.OrganizationResponse;

import java.util.List;

public interface IOrganizationQueryService {
    List<OrganizationResponse> handle(GetAllOrganizationsQuery query);
    OrganizationResponse handle(GetOrganizationByIdQuery query);
}
