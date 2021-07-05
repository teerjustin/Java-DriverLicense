package com.example.driverLicense.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.driverLicense.models.Person;


@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{
	List<Person> findAll();
}
