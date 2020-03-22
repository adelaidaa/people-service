package com.adelaida.people.adapters.rest;

import com.adelaida.people.core.ports.PersonDto;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class PersonDtoConverterTest {


    @Test
    public void given__personDto__should_return_person_response(){
        PersonDtoConverter converter = new PersonDtoConverter();

        String firstName = "firstName";
        String lastName = "lastName";
        PersonDto personDto =  new PersonDto(firstName, lastName);

        PersonResponse personResponse = converter.convert(personDto);

        assertThat(personResponse.getFirstName(), equalTo(firstName));
    }
}