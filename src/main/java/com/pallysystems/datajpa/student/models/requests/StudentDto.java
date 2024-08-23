package com.pallysystems.datajpa.student.models.requests;

import jakarta.validation.constraints.*;
import org.aspectj.weaver.ast.Not;

public record StudentDto(
        @NotBlank(message = "Student first name is mandatory")
        @Size(min = 3, max = 20, message = "First name must be between 3 and 20 characters")
        String firstName,

        @NotBlank(message = "Student last name is mandatory")
        @Size(min = 3, max = 20, message = "Last name must be between 3 and 20 characters")
        String lastName,

        @NotBlank(message = "Email is mandatory")
        @Email(message = "Email should be valid")
        String email,

        @Min(10)
        @Max(30)
        int age
) {
}
