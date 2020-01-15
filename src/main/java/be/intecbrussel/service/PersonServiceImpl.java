package be.intecbrussel.service;

import be.intecbrussel.data.PersonDao;
import be.intecbrussel.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

//b
@Component("mockService")
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonDao personDao;

    @Override
    public Person getPerson(int id) {
        return personDao.readPerson(id);
    }

    @Override
    public List<Person> getAllPersons() {
        return personDao.getAllPersons();
    }

    @Override
    public void addPerson(Person person) {
        personDao.createPerson(person);
    }

    @Override
    public void addPersons(List<Person> personList) {
        personList.forEach(personDao::createPerson);
    }
}
