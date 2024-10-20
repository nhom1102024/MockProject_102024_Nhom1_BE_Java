package com.be.dto.candidate;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

/**
 * CandidateStatusDTO
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
 * 17-10-2024 thuyhang Create
 * 18-10-2024 thuyhang Update
 */
@Getter
@Setter
public class CandidateStatusDTO {
    @Pattern(regexp = "processed", message = "status must be 'proccessed'")
    private String status;
}
