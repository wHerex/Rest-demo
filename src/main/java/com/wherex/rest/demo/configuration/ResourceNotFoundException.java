package com.wherex.rest.demo.configuration;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String resourceName, Object resourceId) {
        super(String.format("Resource: '%s' with id : '%s' not found.", resourceName, resourceId));
    }
}
