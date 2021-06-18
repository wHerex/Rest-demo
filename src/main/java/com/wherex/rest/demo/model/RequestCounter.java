package com.wherex.rest.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "request_counters")
@Getter
@NoArgsConstructor
public class RequestCounter {

    @Id
    private String login;
    private long counter;

    public RequestCounter(String login) {
        this.login = login;
        counter = 1;
    }
}
