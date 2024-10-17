package com.be.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseObject {
    private int code;
    private String message;
}
