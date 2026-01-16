package br.com.erudio.request.converts;

import br.com.erudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger =  Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id){
        logger.info("finding one person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFistName("Luis");
        person.setLastName("Costa");
        person.setAddress("Uberlandi - Minas Gerais - Brasil");
        person.setGender("Male");
        return person;

    }
}
