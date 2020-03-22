package com.adelaida.people.adapters.rest;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class PersonResponse {
    private final String firstName;
    private final String lastName;
}
