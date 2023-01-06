package com.example.springbootapp.controller;

import com.example.springbootapp.model.User;
import com.example.springbootapp.service.UserService;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers(){
       List<User> users= userService.getUsers();
       return new ResponseEntity<>(users,
               HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity< Optional<User>> getOneUser(@PathVariable("id") Long id){
        Optional<User> user = userService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user){
        User u1 = userService.addUser(user);
        return new ResponseEntity<>(u1,HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
        userService.delUser(id);
        System.out.println("User was deleted");
        return new ResponseEntity<>("User was deleted",HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<User> updateUser(@RequestBody User user)
    {
        User updated = userService.updateUser(user);
        return new ResponseEntity<>(updated,HttpStatus.OK);
    }


}
