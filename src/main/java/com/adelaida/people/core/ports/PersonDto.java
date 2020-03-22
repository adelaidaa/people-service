package com.adelaida.people.core.ports;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class PersonDto {
    private final String firstName;
    private final String lastName;
}
