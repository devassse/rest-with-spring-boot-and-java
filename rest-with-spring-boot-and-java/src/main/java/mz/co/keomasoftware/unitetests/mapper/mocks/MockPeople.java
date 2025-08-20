package mz.co.keomasoftware.unitetests.mapper.mocks;

import mz.co.keomasoftware.data.dto.PeopleDTO;
import mz.co.keomasoftware.model.People;

import java.util.ArrayList;
import java.util.List;

public class MockPeople {
    public People mockEntity() {
        return mockEntity(0);
    }
    
    public PeopleDTO mockDTO() {
        return mockDTO(0);
    }
    
    public List<People> mockEntityList() {
        List<People> persons = new ArrayList<People>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockEntity(i));
        }
        return persons;
    }

    public List<PeopleDTO> mockDTOList() {
        List<PeopleDTO> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockDTO(i));
        }
        return persons;
    }
    
    public People mockEntity(Integer number) {
        People person = new People();
        person.setAddress("Address Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setGender(((number % 2)==0) ? "Male" : "Female");
        person.setId(number.longValue());
        person.setLastName("Last Name Test" + number);
        return person;
    }

    public PeopleDTO mockDTO(Integer number) {
        PeopleDTO person = new PeopleDTO();
        person.setAddress("Address Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setGender(((number % 2)==0) ? "Male" : "Female");
        person.setId(number.longValue());
        person.setLasstName("Last Name Test" + number);
        return person;
    }

}