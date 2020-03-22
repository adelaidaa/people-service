package com.adelaida.people.core.ports;

import com.adelaida.people.adapters.persistence.PersonEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
class PersonEntityConverter implements Converter<PersonEntity, PersonDto> {
    @Override
    public PersonDto convert(PersonEntity personEntity) {
        return new PersonDto(personEntity.getFirstName(), personEntity.getLastName());
    }
}
