package com.hackathon.api.shared.domain.models.error_response;

import java.util.Map;

public class ArgumentErrorResponse extends CodeErrorResponse {
    private Map<String, String> errors;

    public ArgumentErrorResponse(int statusCode, String message, Map<String, String> errorMap)
    {
        super(statusCode, message);
        this.errors = errorMap;
    }
}
