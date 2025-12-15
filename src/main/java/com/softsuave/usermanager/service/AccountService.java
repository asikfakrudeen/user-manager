package com.softsuave.usermanager.service;

import com.softsuave.usermanager.entity.Customer;
import com.softsuave.usermanager.entity.User;

public interface AccountService {
    Customer addPerson(Customer customer);

    void removePerson();
}