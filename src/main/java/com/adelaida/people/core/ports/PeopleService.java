package com.adelaida.people.core.ports;

import com.adelaida.people.adapters.persistence.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PeopleService implements PeopleServiceI {
    @Autowired
    private PersonRepository repository;
    @Autowired
    private PersonEntityConverter converter;

    @Override
    public Set<PersonDto> getPeopleByLastName(String lastName) {
        return repository.findByLastName(lastName)
                .stream()
                .map(person -> converter.convert(person))
                .collect(Collectors.toSet());
    }
}
