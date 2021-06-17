package com.wherex.rest.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class User {

    private long id;
    private String login;
    private String name;
    private String type;

    @JsonProperty("avatar_url")
    private String avatarUrl;

    @JsonProperty("created_at")
    private LocalDate createdAt;
    private double calculations;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private double followers;

    @JsonProperty(value = "public_repos", access = JsonProperty.Access.WRITE_ONLY)
    private double publicRepos;

    public void setCalculations(double calculations) {
        this.calculations = calculations;
    }
}
