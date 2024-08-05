package com.hackathon.api.volunteering.interfaces.rest;

import com.hackathon.api.volunteering.application.features.VolunteerCommandService;
import com.hackathon.api.volunteering.application.features.VolunteerQueryService;
import com.hackathon.api.volunteering.domain.models.commands.CreateRegistrationCitizenCommand;
import com.hackathon.api.volunteering.domain.models.commands.CreateVolunteerCommand;
import com.hackathon.api.volunteering.domain.models.queries.GetAllVolunteersQuery;
import com.hackathon.api.volunteering.domain.models.queries.GetVolunteerByIdQuery;
import com.hackathon.api.volunteering.domain.models.responses.VolunteerResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/volunteers")
@CrossOrigin(origins = "*")
public class VolunteerController {
    @Autowired
    private VolunteerCommandService volunteerCommandService;

    @Autowired
    private VolunteerQueryService volunteerQueryService;

    @GetMapping
    public ResponseEntity<List<VolunteerResponse>> getVolunteers() {
        var query = new GetAllVolunteersQuery();
        var volunteers = volunteerQueryService.getAllVolunteers(query);
        return ResponseEntity.ok(volunteers);
    }

    @GetMapping("{id}")
    public ResponseEntity<VolunteerResponse> getVolunteerById(Long id) {
        var query = new GetVolunteerByIdQuery(id);
        var volunteer = volunteerQueryService.getVolunteerById(query);
        return ResponseEntity.ok(volunteer);
    }

    @PostMapping
    public ResponseEntity<VolunteerResponse> createVolunteer(
            @Valid @RequestBody CreateVolunteerCommand command
    )
    {
        var volunteer = volunteerCommandService.createVolunteer(command);
        return ResponseEntity.ok(volunteer);
    }

    @PostMapping("/registration")
    public ResponseEntity<?> createRegistrationCitizen(
            @Valid @RequestBody CreateRegistrationCitizenCommand command
    )
    {
        volunteerCommandService.createRegistrationCitizen(command);
        return ResponseEntity.ok().build();
    }
}
