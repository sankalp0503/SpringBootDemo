package com.example.demoproduct.controller;

import com.example.demoproduct.model.User;
import com.example.demoproduct.request.UserRequest;
import com.example.demoproduct.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {




        private UserService userService;



        @PostMapping
        public void addUsers(@RequestBody final List<User> users){
            userService.addAllUsers(users);
        }



        @GetMapping
        public List<User> findAllUsers(){
            return userService.getAllUsers();
        }



        @GetMapping("/{userId}")
        public User findUserById(@PathVariable final String userId){
            return userService.findUser(userId);
        }


        @DeleteMapping("/{userId}")
        public void deleteUserById(@PathVariable final String userId) {
            userService.delete(userId);

        }


        @PutMapping("/{userId}")
        public void updateUserById(@PathVariable final String userId, @RequestBody UserRequest user){
           userService.update(userId,user) ;

        }

    }
