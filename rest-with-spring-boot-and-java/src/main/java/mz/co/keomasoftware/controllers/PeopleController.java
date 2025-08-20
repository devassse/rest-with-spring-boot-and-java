package mz.co.keomasoftware.controllers;

import mz.co.keomasoftware.data.dto.PeopleDTO;
import mz.co.keomasoftware.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private PeopleService service;

    @RequestMapping(value = "/{id}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PeopleDTO fingById(@PathVariable("id") Long id){
        return service.findById(id);
    }

    @RequestMapping(value = "/findAll",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<PeopleDTO> findAll(){
        return service.findAll();
    }

    @RequestMapping(
    method = RequestMethod.POST,
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public PeopleDTO create(@RequestBody PeopleDTO person){
        return service.createOne(person);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PeopleDTO update(@RequestBody PeopleDTO person){
        return service.update(person);
    }

    @RequestMapping(
            method = RequestMethod.DELETE)
    public void remove(@PathVariable Long id){
        service.removeById(id);
    }

}
