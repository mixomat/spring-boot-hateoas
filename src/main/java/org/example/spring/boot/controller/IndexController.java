package org.example.spring.boot.controller;

import org.example.spring.boot.resources.Index;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class IndexController {

    @RequestMapping("/")
    public HttpEntity<Index> index() {
        final Index index = new Index();
        index.add(linkTo(methodOn(GreetingController.class).greeting("world")).withRel("greeting"));

        return new ResponseEntity<>(index, HttpStatus.OK);
    }
}
