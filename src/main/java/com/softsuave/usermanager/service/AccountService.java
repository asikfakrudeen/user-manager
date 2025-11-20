package com.softsuave.usermanager.service;

import com.softsuave.usermanager.entity.User;

public interface AccountService {
    User addPerson(User user);

    void removePerson();
}