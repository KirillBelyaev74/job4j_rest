package ru.job4j.job4j_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.job4j.job4j_rest.model.Employee;
import ru.job4j.job4j_rest.model.Person;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String API = "http://localhost:8080/person/";

    private static final String API_ID = "http://localhost:8080/person/{id}";

    @GetMapping("/")
    public List<Employee> getAllEmployees() {
        AtomicInteger index = new AtomicInteger(1);
        return restTemplate.exchange(
                API, HttpMethod.GET, null, new ParameterizedTypeReference<List<Person>>() {}
        ).getBody().stream().map(p -> {
            Employee employee = new Employee(p.getLogin(), p.getLogin(), index.getAndIncrement());
            employee.setId(p.getId());
            employee.setPerson(p);
            return employee;
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getById(@PathVariable int id) {
        Person person = restTemplate.getForObject(API_ID, Person.class, id);
        return person == null
                ? new ResponseEntity<>(new Person(), HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Person> create(@RequestBody Person person) {
        Person result = restTemplate.postForObject(API, person, Person.class);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Void> update(@RequestBody Person person) {
        restTemplate.put(API, person);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        restTemplate.delete(API_ID, id);
        return ResponseEntity.ok().build();
    }
}
