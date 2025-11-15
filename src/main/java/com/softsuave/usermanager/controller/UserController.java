package com.softsuave.usermanager.controller;

import com.softsuave.usermanager.dto.UserRequest;
import com.softsuave.usermanager.dto.UserResponse;
import com.softsuave.usermanager.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest){
        log.info("API hit successful and received payload : {} ",userRequest.toString());
        UserResponse response = userService.createUser(userRequest);
        log.info("Returning response : {} ", response.toString());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/createUsers")
    public ResponseEntity<List<UserResponse>> createUsers(@RequestBody List<UserRequest> userRequests){
        log.info("API hit successful");
        List<UserResponse> responses = userService.createUsers(userRequests);
        return new ResponseEntity<>(responses, HttpStatus.CREATED);
    }

    @GetMapping("/getAllUsers/{page}")
    public ResponseEntity<List<UserResponse>> getAllUsers(@PathVariable Integer page){
        log.info("API hit successful and would return data shortly");
        return userService.getAllUsers(page);
    }

    @GetMapping("/getUserById")
    public ResponseEntity<UserResponse> getUserById(@RequestParam String id){
        log.info("API hit successful and would return data for the ID : {} ",id);
        UserResponse response =  userService.getUserById(id);
        log.info("Returning response : {} ", response.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getUserByPermanentIdentificationNumber")
    public ResponseEntity<UserResponse> getUserByPin(@RequestParam Long pin){
        log.info("API hit successful and would return data for the Permanent Identification Number : {} ",pin);
        UserResponse response =  userService.getUserByPin(pin);
        log.info("Returning response : {} ", response.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/filter/{page}")
    public ResponseEntity<List<UserResponse>> getUserByFilter(@PathVariable int page, @RequestParam String country, String state, String city){
        log.info("API hit successful and would return data for the filter");
        List<UserResponse> responses =  userService.getUserByFilter(country, state, city, page);
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @DeleteMapping("/removeAllUsers")
    public ResponseEntity<Void> removeAllUsers(){
        log.info("API hit successful");
        userService.removeAllUsers();
        log.info("User data have been completely wiped out");
        return ResponseEntity.noContent().build();
    }
}