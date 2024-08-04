package com.hackathon.api.security.interfaces.rest;

import com.hackathon.api.security.domain.models.queries.GetAllOrganizationsQuery;
import com.hackathon.api.security.domain.models.queries.GetOrganizationByIdQuery;
import com.hackathon.api.security.domain.models.responses.OrganizationResponse;
import com.hackathon.api.security.domain.services.IOrganizationQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/organizations")
@CrossOrigin(origins = "*")
public class OrganizationController {
    @Autowired
    private IOrganizationQueryService organizationQueryService;

    @GetMapping
    public ResponseEntity<List<OrganizationResponse>> getAllOrganizations() {
        var query = new GetAllOrganizationsQuery();
        var organizations = organizationQueryService.handle(query);
        return ResponseEntity.ok(organizations);
    }

    @GetMapping("{id}")
    public ResponseEntity<OrganizationResponse> getOrganizationById(@PathVariable Long id) {
        var query = new GetOrganizationByIdQuery(id);
        var organization = organizationQueryService.handle(query);
        return ResponseEntity.ok(organization);
    }
}
