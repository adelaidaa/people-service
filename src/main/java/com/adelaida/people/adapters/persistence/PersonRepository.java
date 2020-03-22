package com.adelaida.people.adapters.persistence;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends PagingAndSortingRepository<PersonEntity, Long> {

    List<PersonEntity> findByLastName(@Param("name") String name);

}