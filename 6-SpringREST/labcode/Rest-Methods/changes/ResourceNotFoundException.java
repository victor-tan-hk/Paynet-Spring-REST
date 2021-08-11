package com.workshop.rest;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "The resource could not be located")
public class ResourceNotFoundException extends RuntimeException {


}