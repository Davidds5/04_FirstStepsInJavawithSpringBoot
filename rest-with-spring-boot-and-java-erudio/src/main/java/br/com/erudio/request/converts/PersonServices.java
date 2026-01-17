package br.com.erudio.request.converts;

import br.com.erudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll() {
        logger.info("Finding All person!");
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            persons.add(mockPerson(i));
        }
        return persons;
    }

    public Person findById(Long id) {
        logger.info("Finding one person!");

        Person person = new Person();
        person.setId(id);
        person.setFisrtName("Luis");
        person.setLastName("Costa");
        person.setAddress("Uberlandia - Minas Gerais - Brasil");
        person.setGender("Male");
        return person;
    }
    public Person create(Person person){
        logger.info("Creating one person!");

        return person;
    }
    public Person upDate(Person person){
        logger.info("Updating one person!");

        return person;
    }
    public void delete(String id){
        logger.info("Deleting one person!");

    }

    private Person mockPerson(int i) {
        logger.info("Finding one person!");
        Person person = new Person();
        person.setId((long) i);
        person.setFisrtName("FirstName " + i);
        person.setLastName("LastName " + i);
        person.setAddress("Some Address in Brazil " + i);
        person.setGender("Gender " + i);
        return person;
    }
}
