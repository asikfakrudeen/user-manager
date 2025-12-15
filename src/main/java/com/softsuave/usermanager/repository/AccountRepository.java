package com.softsuave.usermanager.repository;

import com.softsuave.usermanager.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Customer, String>  {
}