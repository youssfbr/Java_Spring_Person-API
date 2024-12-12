package com.github.youssfbr.person_api_2024.api.controllers.exceptions;

import java.time.LocalDateTime;

public record  ErrorResponse(
        LocalDateTime timestamp ,
        int status ,
        String error
) {
}
