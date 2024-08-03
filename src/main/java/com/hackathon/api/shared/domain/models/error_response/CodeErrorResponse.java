package com.hackathon.api.shared.domain.models.error_response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodeErrorResponse {
    private int statusCode;
    private String message;
}
