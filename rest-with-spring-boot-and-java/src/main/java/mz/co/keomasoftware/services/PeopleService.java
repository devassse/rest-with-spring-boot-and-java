package mz.co.keomasoftware.services;

import mz.co.keomasoftware.model.People;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PeopleService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PeopleService.class.getName());

    public List<People> findAll(){

        ArrayList<People> people = new ArrayList<>();
        for (var i = 0; i < 8; i++) {
            People person = mockPeople(i);

            System.out.println("Person " + i + " " + person);

            people.add(person);
        }

        return people;
    }

    public People findById(String id) {
        logger.info("Finding one Person");

        People person = new People();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Joao Devson");
        person.setLasstName("Mucavel");
        person.setAddress("Matola Gare, Q&");
        person.setGender("Male");

        return person;
    }

    private People mockPeople(int i){
        People person = new People();

        person.setId(counter.incrementAndGet());
        person.setFirstName("Firstname " + i);
        person.setLasstName("Lastname" + i);
        person.setAddress("Matola Gare, Q&" + i);
        person.setGender("Male");

        return person;
    }
}
