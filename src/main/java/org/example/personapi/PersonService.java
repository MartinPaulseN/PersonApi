package org.example.personapi;

import com.example.personapi.model.Person;
import com.example.personapi.respository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final org.example.personapi.PersonRepository repository;

    public PersonService(org.example.personapi.PersonRepository repository) {
        this.repository = repository;
    }

    public Person createPerson(Person person) {
        return repository.save(person);
    }

    public Optional<Person> getPersonById(Long id) {
        return repository.findById(id);
    }

    public List<Person> getAllPersons() {
        return repository.findAll();
    }

    public List<Person> searchByFirstName(String firstName) {
        return repository.findByFirstName(firstName);
    }

    public List<Person> searchByAgeGreaterThan(int age) {
        return repository.findByAgeGreaterThan(age);
    }

    public Person updatePerson(Long id, Person updatedPerson) {
        updatedPerson.setId(id);
        return repository.save(updatedPerson);
    }

    public void deletePerson(Long id) {
        repository.deleteById(id);
    }
}
