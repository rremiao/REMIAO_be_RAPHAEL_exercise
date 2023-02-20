package com.ecore.roles.exception;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
@Data
public class ErrorResponse {

    private final int status;
    private final String error;

}
