package com.softsuave.usermanager.controller;

import com.softsuave.usermanager.dto.UserRequest;
import com.softsuave.usermanager.dto.UserResponse;
import com.softsuave.usermanager.entity.User;
import com.softsuave.usermanager.service.AccountService;
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
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/addPerson")
    public ResponseEntity<User> addPerson(@RequestBody User user) {
        log.info("API hit successful and received payload : {} ", user.toString());
        User response = accountService.addPerson(user);
        log.info("Returning response : {} ", response.toString());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/removePerson")
    public String removePerson() {
        accountService.removePerson();
        return "SUCESS";
    }
}