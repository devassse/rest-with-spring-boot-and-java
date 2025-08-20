package mz.co.keomasoftware.services;

import mz.co.keomasoftware.data.dto.PeopleDTO;
import mz.co.keomasoftware.exceptions.ResourceNotFoundException;
import mz.co.keomasoftware.mapper.ObjectMapper;
import mz.co.keomasoftware.model.People;
import mz.co.keomasoftware.repositories.PeopleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PeopleService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = LoggerFactory.getLogger(PeopleService.class.getName());

    @Autowired
    private PeopleRepository repository;

    public List<PeopleDTO> findAll(){
        logger.info("Find All People");
        return ObjectMapper.parseListObjects(repository.findAll(), PeopleDTO.class);
    }

    public PeopleDTO findById(Long id) {
        logger.info("Finding one Person");
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Records Found for this ID"));
        return ObjectMapper.parseObject(entity, PeopleDTO.class);
    }

    public PeopleDTO createOne(PeopleDTO person){
        logger.info("Creating a Person");

        var entity = ObjectMapper.parseObject(person, People.class);

        return ObjectMapper.parseObject(repository.save(entity), PeopleDTO.class);
    }

    public PeopleDTO update(PeopleDTO person){
        logger.info("Updating a Person");

        People entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No Records Found for this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return ObjectMapper.parseObject(repository.save(entity), PeopleDTO.class);
    }

    public void removeById(Long id){
        logger.info("Deleting a Person");
        People entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Records Found for this ID"));
        repository.delete(entity);
    }
}
