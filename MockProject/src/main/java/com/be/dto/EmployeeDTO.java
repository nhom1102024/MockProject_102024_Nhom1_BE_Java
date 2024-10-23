package com.be.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeDTO {
     private String username;
     private String email;
     private String firstName;
     private String lastName;
     private String password;
     private Date dayOfBirth;
     private String address;
     private String phoneNumber;
}
