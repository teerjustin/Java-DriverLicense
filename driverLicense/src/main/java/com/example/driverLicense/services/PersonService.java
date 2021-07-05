package com.example.driverLicense.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.driverLicense.models.Person;
import com.example.driverLicense.repositories.PersonRepository;


@Service
public class PersonService {
    // adding the book repository as a dependency
    private final PersonRepository personRepository;
    
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    
    // returns all the persons
    public List<Person> allPersons() {
        return personRepository.findAll();
    }
    // creates a persons
    public Person createPerson(Person b) {
        return personRepository.save(b);
    }
    
	public void deletePerson(Long id) {
		personRepository.deleteById(id);
	}
    
	//update person
	public Person updatePerson(Long id, String firstName, String lastName) {
		Optional<Person> person = personRepository.findById(id);
		Person b = person.get();
		b.setFirstName(firstName);
		b.setLastName(lastName);
		return personRepository.save(b);
	}
   
    // retrieves a person
    public Person findPerson(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if(optionalPerson.isPresent()) {
            return optionalPerson.get();
        } else {
            return null;
        }
    }

}