package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.student;

public interface StudentRepo extends CrudRepository<student, Integer> {

}
