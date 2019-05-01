package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.SFDC;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface SFDCRepository extends CrudRepository<SFDC, Integer> {

}

