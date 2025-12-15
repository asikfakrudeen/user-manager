package com.softsuave.usermanager.service;

import com.softsuave.usermanager.dto.UserRequest;
import com.softsuave.usermanager.dto.UserResponse;
import com.softsuave.usermanager.entity.Customer;
import com.softsuave.usermanager.entity.User;
import com.softsuave.usermanager.repository.AccountRepository;
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
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final UserMapper userMapper;

    public AccountServiceImpl(AccountRepository accountRepository, UserMapper userMapper) {
        this.accountRepository = accountRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Customer addPerson(Customer customer) {
        return accountRepository.save(customer);
    }

    @Override
    public void removePerson() {
        accountRepository.deleteAll();
    }
}