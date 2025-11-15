package com.softsuave.usermanager.repository;

import com.softsuave.usermanager.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByPin(Long pin);

    List<User> findByCountryAndStateAndCity(String country, String state, String city, Pageable pageable);
}