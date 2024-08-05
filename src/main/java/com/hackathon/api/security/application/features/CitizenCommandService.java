package com.hackathon.api.security.application.features;

import com.hackathon.api.security.domain.models.commands.CreateCitizenCommand;
import com.hackathon.api.security.domain.models.entities.Citizen;
import com.hackathon.api.security.domain.models.responses.CitizenResponse;
import com.hackathon.api.security.domain.services.ICitizenCommandService;
import com.hackathon.api.security.infrastructure.persistence.repositories.ICitizenRepository;
import com.hackathon.api.shared.application.exceptions.ConflictException;
import com.hackathon.api.shared.application.exceptions.ValidationException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CitizenCommandService implements ICitizenCommandService {
    @Autowired
    private ICitizenRepository citizenRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public CitizenResponse handle(CreateCitizenCommand command) {
        var citizen = mapper.map(command, Citizen.class);

        // Business logic here
        citizen.setProfileImage("https://camo.githubusercontent.com/65eac2eb9bb41fefaa3800d8ee40a7139fc25d9372037550944b5c5fb1e6a6fd/68747470733a2f2f7261772e6769746875622e636f6d2f68617368646f672f6e6f64652d6964656e7469636f6e2d6769746875622f6d61737465722f6578616d706c65732f696d616765732f6769746875622e706e67");

        if (!command.getPassword().equals(command.getConfirmedPassword())) {
            throw new ValidationException("Passwords do not match");
        }

        var citizenWithSameEmail = citizenRepository.findByEmail(command.getEmail());

        if (citizenWithSameEmail != null) {
            throw new ConflictException("Email already in use");
        }

        var citizenWithSameUsername = citizenRepository.findByUsername(command.getUsername());

        if (citizenWithSameUsername != null) {
            throw new ConflictException("Username already in use");
        }

        citizen.setPassword(passwordEncoder.encode(command.getPassword()));

        var newCitizen = citizenRepository.save(citizen);

        return mapper.map(newCitizen, CitizenResponse.class);
    }
}
