package com.example.springboot_dao_services_crud_hw.dao;

import com.example.springboot_dao_services_crud_hw.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDAO extends JpaRepository<User,Integer> {
    @Query("select u from User u where u.name=:name")
    List<User> getUserByName(@Param("name") String name);
    List<User> getUserBySurname(String surname);
}
