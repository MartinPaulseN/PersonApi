package org.example.personapi;

import com.example.personapi.model.Person;
import com.example.personapi.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<List<Person>> createPerson(@RequestBody Person person) {
        return ResponseEntity.ok(service.createPerson(person));
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPersons() {
        return ResponseEntity.ok(service.getAllPersons());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        return service.getPersonById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search/firstName")
    public ResponseEntity<List<Person>> searchByFirstname(@RequestParam String firstName) {
        return ResponseEntity.ok(service.searchByFirstName(firstName));
    }

    @GetMapping("/search/age")
    public ResponseEntity<List<Person>> searchByAge(@RequestParam int age) {
        return ResponseEntity.ok(service.searchByAgeGreaterThan(age));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatedPerson(@PathVariable Long id, @RequestBody Person person) {
        return ResponseEntity.ok(service.updatedPerson(id, person));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        service.deletePerson(id);
        return ResponseEntity.noContent().build();
    }
}
