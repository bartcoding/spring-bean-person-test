package be.intecbrussel.service;

import be.intecbrussel.model.Person;

import java.util.List;

public interface PersonService {

    Person getPerson(int id);
    List<Person> getAllPersons();
    void addPerson(Person person);
    void addPersons(List <Person> personList);


}
