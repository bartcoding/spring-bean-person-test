package be.intecbrussel;

import be.intecbrussel.model.Person;
import be.intecbrussel.service.PersonService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        //a
        ConfigurableApplicationContext context
                = new AnnotationConfigApplicationContext(PersonSpringConfiguration.class);
        //b
        PersonService service = context.getBean("mockService",PersonService.class);
        //c
        Person person1 = context.getBean("person",Person.class);
        person1.setFirstName("Bart");
        person1.setLastName("Hunerbein");
        person1.setDateOfBirth(LocalDate.of(1989,7,14));
        service.addPerson(person1);
        //d
        Person person2 = context.getBean("person",Person.class);
        person2.setFirstName("Mart");
        person2.setLastName("Hunerbeen");
        Person person3 = context.getBean("person",Person.class);
        person3.setFirstName("Bert");
        person3.setLastName("Hunerstein");
        Person person4 = context.getBean("person",Person.class);
        person4.setFirstName("Bjard");
        person4.setLastName("Honerhein");
        List<Person> peeps = new ArrayList<>();
        peeps.add(person2);
        peeps.add(person3);
        peeps.add(person4);
        service.addPersons(peeps);
        //e
        service.getAllPersons().stream().forEach(System.out::println);
        //g
        Person person5 = context.getBean("person",Person.class);
        person5.setFirstName("Johannah");
        person5.setLastName("von Hunerbein");
        //h,i
        peeps.add(person5);
        service.getAllPersons().stream().forEach(System.out::println);
    }
}
