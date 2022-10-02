package com.hostbooks.SchoolManagementSystemAPI.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ErrorDetails {

    private LocalDateTime timestamp;
    private String message;
    private String details;
}
