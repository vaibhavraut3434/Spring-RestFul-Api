package com.in28minutes.rest.webservices.restfulwebservices.exception;

import jdk.jfr.DataAmount;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {

    private LocalDate timestamp;
    private String message;
    private String details;
}
