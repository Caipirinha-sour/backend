package com.hackathon.api.security.application.features;

import com.hackathon.api.security.domain.models.queries.GetAllOrganizationsQuery;
import com.hackathon.api.security.domain.models.queries.GetOrganizationByIdQuery;
import com.hackathon.api.security.domain.models.responses.OrganizationResponse;
import com.hackathon.api.security.domain.services.IOrganizationQueryService;
import com.hackathon.api.security.infrastructure.persistence.repositories.IOrganizationRepository;
import com.hackathon.api.shared.application.exceptions.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationQueryService implements IOrganizationQueryService {
    @Autowired
    private IOrganizationRepository organizationRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<OrganizationResponse> handle(GetAllOrganizationsQuery query) {
        var organizations = organizationRepository.findAll();

        return organizations.stream()
                .map(organization -> mapper.map(organization, OrganizationResponse.class))
                .toList();
    }

    @Override
    public OrganizationResponse handle(GetOrganizationByIdQuery query) {
        var organization = organizationRepository.findById(query.id())
                .orElseThrow(() -> new NotFoundException("Organization not found"));

        return mapper.map(organization, OrganizationResponse.class);
    }
}
