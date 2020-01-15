package be.intecbrussel.data;


import be.intecbrussel.model.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//a
@Component("mockDao")
public class PersonDaoImpl implements PersonDao {
    //a
    private List<Person> personDB = new ArrayList<>();

    @Override
    public boolean createPerson(Person person) {
        if (!personExists(person)) {
            return personDB.add(person);
        } else {
            return false;
        }
    }


    @Override
    public Person readPerson(int id) {
        Optional<Person> person = personDB.stream().filter(p -> p.getId() == id).findFirst();
        if (person.isPresent()) {
            return person.get();
        } else return null;
    }

    @Override
    public boolean updatePerson(Person person) {
        if (personExists(person)) {
            personDB.removeIf(person1 -> person1.getId() == person.getId());
            personDB.add(person);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deletePerson(Person person) {
        if (personExists(person)) {
            personDB.removeIf(person1 -> person1.getId() == person.getId());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Person> getAllPersons() {
        return new ArrayList<>(personDB);
    }

    private boolean personExists(Person person) {
        return personDB.stream().anyMatch(p -> p.getId() == person.getId());
    }
}
