package com.example.service;

import com.example.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonService {
    private List<Person> persons = new ArrayList<>();

    public void addPerson(Person person) {
        persons.add(person);
    }

    public void removePerson(int id) {
        persons.removeIf(person -> person.getId() == id);
    }

    public Optional<Person> findPersonById(int id) {
        return persons.stream()
                .filter(person -> person.getId() == id)
                .findFirst();
    }

    public List<Person> getAllPersons() {
        return new ArrayList<>(persons);
    }
}
