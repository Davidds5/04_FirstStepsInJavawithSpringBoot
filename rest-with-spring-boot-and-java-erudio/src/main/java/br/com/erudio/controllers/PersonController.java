package br.com.erudio.controllers;

import br.com.erudio.model.Person;
import br.com.erudio.request.converts.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AliasFor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.standard.Media;

@RequestMapping("/person")
@RestController
public class PersonController {

    @Autowired
    private PersonServices services;

    @RequestMapping(value = "/{id}",
    method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE)

    public Person findById(@PathVariable("id") String id){
        return services.findById(id);
    }
}
