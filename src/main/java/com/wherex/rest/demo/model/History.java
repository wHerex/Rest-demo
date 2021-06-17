package com.wherex.rest.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class History {

    @Id
    private String login;
    private long counter;

    public History(String login){
        this.login = login;
        counter = 1;
    }
}
