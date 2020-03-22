package com.adelaida.people.adapters.rest;

import com.adelaida.people.core.ports.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class PeopleController {

    private final PeopleService peopleService;
    private final PersonDtoConverter personDtoConverter;

    @Autowired
    public PeopleController(PeopleService peopleService, PersonDtoConverter personDtoConverter) {
        this.peopleService = peopleService;
        this.personDtoConverter = personDtoConverter;
    }

    @GetMapping(path = "/people/{lastName}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Set<PersonResponse> getPeople(@PathVariable String lastName) {
        return peopleService.getPeopleByLastName(lastName)
                .stream()
                .map(personDto -> personDtoConverter.convert(personDto))
                .collect(Collectors.toSet());
    }
}
