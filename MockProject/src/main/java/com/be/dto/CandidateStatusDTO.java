package com.be.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CandidateStatusDTO {
    @JsonProperty("status")
    private String status;
}
