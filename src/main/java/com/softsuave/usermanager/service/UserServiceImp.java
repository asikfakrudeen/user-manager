package com.softsuave.usermanager.service;

import com.softsuave.usermanager.dto.UserRequest;
import com.softsuave.usermanager.dto.UserResponse;
import com.softsuave.usermanager.entity.User;
import com.softsuave.usermanager.repository.UserRepository;
import com.softsuave.usermanager.utility.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImp(UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserResponse createUser(UserRequest userRequest) {

        User user = userMapper.mapToUserEntity(userRequest);
        userRepository.save(user);
        return userMapper.mapToUserResponse(user);
    }

    @Override
    public List<UserResponse> createUsers(List<UserRequest> userRequests) {

        log.info("API hit successful");

        List<UserResponse> responses = new ArrayList<>();
        for (UserRequest userRequest : userRequests){
            User user = userMapper.mapToUserEntity(userRequest);
            userRepository.save(user);
            UserResponse response = userMapper.mapToUserResponse(user);
            responses.add(response);
        }
        return responses;
    }

    @Override
    public ResponseEntity<List<UserResponse>> getAllUsers(Integer page) {
        int size = 5;
        Pageable pageable = PageRequest.of(page-1, size);
        Page<User> pageOfUsers = userRepository.findAll(pageable);
        List<User> users = pageOfUsers.getContent();
        List<UserResponse> responses = new ArrayList<>();
        for (User user : users){
            UserResponse response = userMapper.mapToUserResponse(user);
            log.info("Received API and payload {} ",response.toString());
            responses.add(response);
        }
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @Override
    public UserResponse getUserById(String id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return userMapper.mapToUserResponse(user.get());
        }
        else {
            throw new RuntimeException("Data not found");
        }
    }

    @Override
    public UserResponse getUserByPin(Long pin) {
        Optional<User> user = userRepository.findByPin(pin);
        if (user.isPresent()) {
            return userMapper.mapToUserResponse(user.get());
        }
        else {
            throw new RuntimeException("Data not found");
        }
    }

    @Override
    public UserResponse getUserByMobileNumber(Long mobileNumber) {
        Optional<User> user = userRepository.getUserByMobileNumber(mobileNumber);
        if (user.isPresent()) {
            return userMapper.mapToUserResponse(user.get());
        }
        else {
            throw new RuntimeException("Data not found");
        }
    }

    @Override
    public void removeAllUsers() {
        userRepository.deleteAll();
    }

    @Override
    public Page<UserResponse> getUserByFilter(String country, String state, String city, int page) {
        int pageSize = 5;
        Pageable pageable = PageRequest.of(page-1, pageSize);
        Page<User> userPage = userRepository.findByCountryAndStateAndCity(country, state, city, pageable);
        return userPage.map(userMapper::mapToUserResponse);
    }

    @Override
    public Page<UserResponse> getUserByDynamicFilter(String gender, String nationality, String country, String state, String city, Byte age, int page) {
        int pageSize = 5;
        Pageable pageable = PageRequest.of(page-1, pageSize);
        Page<User> userPage = userRepository.findByDynamicFilter(gender, nationality, country, state, city, age, pageable);
        return userPage.map(userMapper::mapToUserResponse);
    }
}