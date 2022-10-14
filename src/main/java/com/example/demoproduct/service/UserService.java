package com.example.demoproduct.service;

import com.example.demoproduct.model.User;
import com.example.demoproduct.repository.UserRepository;

import com.example.demoproduct.request.UserRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {


    private UserRepository userRepository;



    //POST
    public void addAllUsers(@RequestBody final List<User> users){
        userRepository.saveAll(users);
    }



    //GET
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }



    //GETbyID
    public User findUser(@PathVariable final String userId){
        return userRepository.findById(userId).orElseGet(User::new);
    }


    //DELETE
    public ResponseEntity delete(@PathVariable final String userId) {

        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            userRepository.deleteById(userId);
            return ResponseEntity.ok("Success");
        } else {
            return  ResponseEntity.badRequest().body("the product with id:" + userId + "was not found");
        }
    }


    //PUT
    public void update(@PathVariable final String userId, @RequestBody UserRequest user){
        User savedUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot find userby id %s ",userId)));

        savedUser.setName(user.getName());
        savedUser.setMobile(user.getMobile());
        savedUser.setEmail(user.getEmail());
        savedUser.setAddress(user.getAddress());



        userRepository.save(savedUser);

    }

}
