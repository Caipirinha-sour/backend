package com.hackathon.api.security.domain.models.commands;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCitizenCommand {
    @NotEmpty(message = "Username may not be empty")
    @Size(min=4, max=16, message = "Username must be between 4 and 16 characters long")
    private String username;

    @NotEmpty(message = "Password may not be empty")
    @Size(min=4, max=16, message = "Password must be between 8 and 16 characters long")
    private String password;

    @NotEmpty(message = "Confirmed Password may not be empty")
    @Size(min=4, max=16, message = "Confirmed password must be between 8 and 16 characters long")
    private String confirmedPassword;

    @NotEmpty(message = "Email may not be empty")
    @Email(message = "Email should be valid")
    private String email;
}
