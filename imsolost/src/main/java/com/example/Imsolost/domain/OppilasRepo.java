package com.example.Imsolost.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface OppilasRepo extends CrudRepository<Oppilas, Long> {

    List<Oppilas> findByLastName(String lastName);
    
}