package com.adelaida.people.core.ports;

import java.util.Set;

public interface PeopleServiceI {
    Set<PersonDto> getPeopleByLastName(final String lastName);
}
