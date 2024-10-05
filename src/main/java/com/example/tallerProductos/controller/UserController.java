package com.example.tallerProductos.controller;

import com.example.tallerProductos.dto.UserDto;
import com.example.tallerProductos.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.tallerProductos.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired //Singleton backwards for just one userService instance
    private UserService userService;

    //This method refers to userService.findAll() method. Brings out every user stored in database table user as a List of users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }


    //This method refers to userService.findById() method. Finds a specific user searching by id
    //If the user is found, maps the ResponseEntity and returns a 200 OK Status.
    //If there is not a user identified by that id, returns 404 Not Found Status
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id) {
        Optional<User> user = userService.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //This method refers to userService.save() method. Saves a new user in database table user
    @PostMapping
    public User createUser(@RequestBody UserDto userDto) {
        return userService.save(userDto);
    }

    //This method refers to userService.findById() and userService.save() methods. Finds a specific user searching by id and updates it
    //If the user is found, sets the attributes to the user in edition, saves to update and returns a 200 OK Status.
    //If there is not a user identified by that id, returns 404 Not Found Status
    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable long id, @RequestBody User user) {
        Optional<User> findUser = userService.findById(id);
        if (findUser.isPresent()) {
            UserDto userDto = new UserDto();
            userDto.setName(user.getName());
            userDto.setLastName(user.getLastName());
            userDto.setAdress(user.getAdress());
            userDto.setPassword(user.getPassword());
            userDto.setUsername(user.getUsername());
            userDto.setProduct(user.getProduct());
            return ResponseEntity.ok(userService.update(userDto));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //This method refers to userService.findById() and userService.deleteById() methods. Finds a specific user searching by id and deletes it
    //If the user is found, deletes it.
    //If there is not a user identified by that id, returns 404 Not Found Status
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        if (userService.findById(id).isPresent()) {
            userService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
