package com.example.springboot_dao_services_crud_hw.services;

import com.example.springboot_dao_services_crud_hw.dao.UserDAO;
import com.example.springboot_dao_services_crud_hw.models.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private UserDAO userDAO;

    public void save(User user){
        userDAO.save(user);
    }
    public ResponseEntity<List<User>> getUsers(){
        return new ResponseEntity<>(userDAO.findAll(), HttpStatus.OK);
    }
    public ResponseEntity<User> getById(int id){
        return new ResponseEntity<>(userDAO.findById(id).get(),HttpStatus.OK);
    }

    public ResponseEntity<User> update(int id,User user){
        User user1=userDAO.findById(id).get();
        user1.setName(user.getName());
        userDAO.save(user1);
        return new ResponseEntity<>(user1,HttpStatus.OK);
    }
    public void deleteById(int id){
        userDAO.deleteById(id);
    }
}
