package com.adelaida.people.adapters.persistence;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PersonRepositoryTest {
    @Autowired
    private PersonRepository personRepository;

    @Test
    public void testGetPeopleByLastName() {
        String lastName = "Last name";
        PersonEntity personEntity1 = savePerson("First name1", lastName);
        PersonEntity personEntity2 = savePerson("First name2", lastName);

        List<PersonEntity> byLastName = personRepository.findByLastName(lastName);

        assertThat(byLastName).hasSize(2);
        assertThat(byLastName).containsExactly(personEntity1, personEntity2);
    }

    private PersonEntity savePerson(String firstName, String lastName) {
        PersonEntity personEntity = PersonEntity.builder()
                .firstName(firstName)
                .lastName(lastName).build();
        personRepository.save(personEntity);
        return personEntity;
    }

}