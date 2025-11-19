package com.softsuave.usermanager.controller;

import com.softsuave.usermanager.dto.UserRequest;
import com.softsuave.usermanager.dto.UserResponse;
import com.softsuave.usermanager.entity.User;
import com.softsuave.usermanager.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addPerson")
    public ResponseEntity<User> addPerson(@RequestBody User user){
        log.info("API hit successful and received payload : {} ",user.toString());
        User response = userService.addPerson(user);
        log.info("Returning response : {} ", response.toString());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
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
        log.info("API hit successful and would return data for this ID : {} ",id);
        UserResponse response =  userService.getUserById(id);
        log.info("Returning response : {} ", response.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getUserByPermanentIdentificationNumber")
    public ResponseEntity<UserResponse> getUserByPin(@RequestParam Long pin){
        log.info("API hit successful and would return data for this Permanent Identification Number : {} ",pin);
        UserResponse response =  userService.getUserByPin(pin);
        log.info("Returning response : {} ", response.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getUserByMobileNumber")
    public ResponseEntity<UserResponse> getUserByMobileNumber(@RequestParam Long mobileNumber){
        log.info("API hit successful and would return data for this mobile number : {} ",mobileNumber);
        UserResponse response =  userService.getUserByMobileNumber(mobileNumber);
        log.info("Returning response : {} ", response.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/filter/{page}")
    public ResponseEntity<Page<UserResponse>> getUserByFilter(@PathVariable int page, @RequestParam String country, String state, String city){
        log.info("API hit successful and would return data for the filter");
        Page<UserResponse> responses =  userService.getUserByFilter(country, state, city, page);
        log.info("Returning filtered data");
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity<Page<UserResponse>> getUserByDynamicFilter(
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) String nationality,
            @RequestParam(required = false) String country,
            @RequestParam(required = false) String state,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) Byte age,
            @RequestParam(defaultValue = "1") int page
    ) {
        log.info("Fetching users with dynamic filters");
        Page<UserResponse> responses = userService.getUserByDynamicFilter(gender, nationality, country, state, city, age, page);
        log.info("Returning filtered data");
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