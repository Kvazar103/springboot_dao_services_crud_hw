package com.example.springboot_dao_services_crud_hw.controllers;

import com.example.springboot_dao_services_crud_hw.dao.UserDAO;
import com.example.springboot_dao_services_crud_hw.models.User;
import com.example.springboot_dao_services_crud_hw.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserDAO userDAO;
    private UserService userService;

    @PostMapping("")
    public void saveUser(@RequestBody User user){
//        userDAO.save(user);
        userService.save(user);
    }
    @GetMapping("")
    public ResponseEntity<List<User>> getUsers(){
       return new ResponseEntity<>(userService.getUsers().getBody(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id){
        return new ResponseEntity<>(userService.getById(id).getBody(),HttpStatus.OK);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<User> updateById(@PathVariable int id,@RequestBody User user){
      User user1=  userService.update(id,user).getBody();
        return new ResponseEntity<>(user1,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        userService.deleteById(id);
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<List<User>> getAllByName(@PathVariable String name){
        return new ResponseEntity<>(userDAO.getUserByName(name),HttpStatus.OK);
    }
    @GetMapping("/surname/{surname}")
    public ResponseEntity<List<User>> getAllBySurname(@PathVariable String surname){
        return new ResponseEntity<>(userDAO.getUserBySurname(surname),HttpStatus.OK);
    }
}
