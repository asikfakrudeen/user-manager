package com.softsuave.usermanager.service;

import com.softsuave.usermanager.dto.UserRequest;
import com.softsuave.usermanager.dto.UserResponse;
import com.softsuave.usermanager.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    UserResponse createUser(UserRequest userRequest);

    List<UserResponse> createUsers(List<UserRequest> userRequests);

    ResponseEntity<List<UserResponse>> getAllUsers(Integer page);

    UserResponse getUserById(String id);

    UserResponse getUserByPin(Long pin);

    void removeAllUsers();

    List<UserResponse> getUserByFilter(String country, String state, String city, int page);
}