package com.be.dto.candidate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

/**
 * CandidateUpdateDTO
 * 
 * Version: 1.0
 * 
 * Date: 17-10-2024
 * 
 * Copyright
 * 
 * Modification Logs:
 * DATE AUTHOR DESCRIPTION
 * -------------------------------------
 * 18-10-2024 thuyhang Create
 */
@Getter
@Setter
public class CandidateUpdateDTO {
    @NotBlank(message = "fullName must not be blank")
    private String fullName;

    @NotBlank(message = "gender must not be blank")
    @Pattern(regexp = "[MF]", message = "gender must be 'M' or 'F'")
    private String gender;

    @NotBlank(message = "phoneNumber must not be blank")
    private String phoneNumber;

    @NotBlank(message = "email must not be blank")
    @Email(message = "Invalid email")
    private String email;

    @NotBlank(message = "identifier must not be blank")
    private String identifier;

    @NotBlank(message = "dateOfBirth must not be blank")
    @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "dateOfBirth must be in format DD/MM/YYYY")
    private String dateOfBirth;

    @NotBlank(message = "address must not be blank")
    private String address;

    @NotBlank(message = "workExperience must not be blank")
    private String workExperience;

    @NotBlank(message = "educationalStatus must not be blank")
    private String educationalStatus;
}
