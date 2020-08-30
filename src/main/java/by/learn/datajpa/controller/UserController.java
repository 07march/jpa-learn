package by.learn.datajpa.controller;

import by.learn.datajpa.entity.User;
import by.learn.datajpa.repository.AddressRepository;
import by.learn.datajpa.repository.TelephoneRepository;
import by.learn.datajpa.repository.UserRepository;
import by.learn.datajpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.add(user), HttpStatus.CREATED);
    }

    @GetMapping(path = "find/all/name")
    public ResponseEntity<List<User>> findAllByName(@RequestParam String name) {
        return new ResponseEntity<>(userService.findAllByName(name), HttpStatus.OK);
    }

    @GetMapping(path = "find/id")
    public ResponseEntity<User> findById(@RequestParam long id) {
        User byId = userService.findById(id);
        if (byId != null) {
            return new ResponseEntity<>(byId, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "/auth")
    public ResponseEntity<String> auth(@RequestParam String login, @RequestParam String password){
        if (userService.authoriz(login, password) != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
