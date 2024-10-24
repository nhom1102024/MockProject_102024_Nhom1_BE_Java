package com.be.response;

import lombok.Builder;
import lombok.Data;

/**
 * ResponseObject
 * 
 * Version: 1.0
 * 
 * Date: 15-10-2024
 * 
 * Copyright
 * 
 * Modification Logs:
 * DATE AUTHOR DESCRIPTION
 * -------------------------------------
 * 15-10-2024 thuyhang Create
 */
@Data
@Builder
public class ResponseObject {
    private int status;
    private String message;
    private Object data;
}
