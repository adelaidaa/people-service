package com.adelaida.people.adapters.rest;

import com.adelaida.people.core.ports.PersonDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
class PersonDtoConverter implements Converter<PersonDto, PersonResponse> {
    @Override
    public PersonResponse convert(PersonDto personDto) {
        return new PersonResponse(personDto.getFirstName(), personDto.getLastName());
    }
}
