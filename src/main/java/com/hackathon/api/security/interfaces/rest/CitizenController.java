package com.hackathon.api.security.interfaces.rest;

import com.hackathon.api.security.domain.models.commands.CreateCitizenCommand;
import com.hackathon.api.security.domain.models.responses.CitizenResponse;
import com.hackathon.api.security.domain.services.ICitizenCommandService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/citizens")
@CrossOrigin(origins = "*")
public class CitizenController {
    @Autowired
    private ICitizenCommandService citizenCommandService;

    @PostMapping
    public ResponseEntity<CitizenResponse> createCitizen(
            @Valid @RequestBody CreateCitizenCommand command
    )
    {
        var citizenResponse = citizenCommandService.handle(command);
        return ResponseEntity.ok(citizenResponse);
    }
}
