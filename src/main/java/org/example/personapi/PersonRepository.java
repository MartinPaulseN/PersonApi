package org.example.personapi;

import com.example.personapi.model.Person;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PersonRepository {
    private Map<Long, Person> personMap = new HashMap<>();

    public Person save(Person person) {
        personMap.put(person.getId(), person);
        return person;
    }

    public Optional<Person> findById(Long id) {
        return Optional.ofNullable(personMap.get(id));
    }

    public List<Person> findAll() {
        return new ArrayList<>(personMap.values());
    }

    public List<Person> findByFirstName(String firstName) {
        List<Person> result = new ArrayList<>();
        for (Person p : personMap.values()) {
            if (p.getFirstName().equalsIgnoreCase(firstName)) {
                result.add(p);
            }
        }
        return result;
    }

    public List<Person> findByAgeGreaterThan(int age) {
        List<Person> result = new ArrayList<>();
        for (Person p : personMap.values()) {
            if (p.getAge() > age) {
                result.add(p);
            }
        }
        return result;
    }

    public void deleteById(Long id) {
        personMap.remove(id);
    }
}
