package com.in28minutes.rest.webservices.restfulwebservices.user;

import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    private UserDAOService service;

    public UserResource(UserDAOService service) {
        this.service = service;
    }
    @GetMapping("/users")
    public List<User1> retrieveAllUsers(){
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public EntityModel<User1> retrieveUser(@PathVariable int id){
        User1 user = service.findOne(id);

        if(user==null)
            throw new UserNotFoundException("id:"+id);
        System.out.println("In retrieveUser method");
        EntityModel<User1> entityModel = EntityModel.of(user);
        WebMvcLinkBuilder webMvcLinkBuilder =
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());

        entityModel.add(webMvcLinkBuilder.withRel("all-users"));
        return entityModel;
    }

    @PostMapping("/users")
    public ResponseEntity<User1> createUser(@Valid @RequestBody User1 user){
        User1 savedUser = service.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
