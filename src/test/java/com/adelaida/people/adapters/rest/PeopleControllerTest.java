package com.adelaida.people.adapters.rest;

import com.adelaida.people.core.ports.PeopleService;
import com.adelaida.people.core.ports.PersonDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Set;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class PeopleControllerTest {
        @MockBean
        private PeopleService peopleService;
        @Autowired
        private MockMvc mockMvc;

        @Test
        public void get_person_byLastName() throws Exception {
            //Mocks
            String lastName= "lastName";
            PersonDto personDto1 = new PersonDto("first name 1", lastName);
            PersonDto personDto2 = new PersonDto("first name 2", lastName);
            given(peopleService.getPeopleByLastName(lastName)).willReturn(Set.of(personDto1, personDto2));

            mockMvc.perform(MockMvcRequestBuilders.get("/people/" + lastName)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\"firstName\":\"first name 1\",\"lastName\":\"lastName\"},{\"firstName\":\"first name 2\",\"lastName\":\"lastName\"}"))
                    .andExpect(status().isOk());
        }
    }