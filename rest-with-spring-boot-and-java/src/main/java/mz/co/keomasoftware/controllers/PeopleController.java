package mz.co.keomasoftware.controllers;

import mz.co.keomasoftware.model.People;
import mz.co.keomasoftware.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
    public People fingById(@PathVariable("id") String id){
        return service.findById(id);
    }

    @RequestMapping(
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<People> findAll(){
        List<People> people = service.findAll();

        System.out.println("People " + people);

        return people;
    }

}
