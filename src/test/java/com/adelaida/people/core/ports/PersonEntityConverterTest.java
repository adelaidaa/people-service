package com.adelaida.people.core.ports;

import com.adelaida.people.adapters.persistence.PersonEntity;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class PersonEntityConverterTest {

    @Test
    public void given__personEntity__should_return_personDto(){
        PersonEntityConverter converter =  new PersonEntityConverter();

        String firstName = "Ade";
        String lastName = "Alonso";
        PersonDto personDto = converter.convert(PersonEntity.builder().firstName(firstName).lastName(lastName).build());

        assertThat(personDto.getFirstName(), equalTo(firstName));
        assertThat(personDto.getLastName(), equalTo(lastName));
    }
}