package com.softsuave.usermanager.repository;

import com.softsuave.usermanager.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByPin(Long pin);

    Optional<User> getUserByMobileNumber(Long mobileNumber);

    Page<User> findByCountryAndStateAndCity(String country, String state, String city, Pageable pageable);

    @Query("SELECT u FROM User u WHERE " +
            "(:gender IS NULL OR u.gender = :gender) AND " +
            "(:nationality IS NULL OR u.nationality = :nationality) AND " +
            "(:country IS NULL OR u.country = :country) AND " +
            "(:state IS NULL OR u.state = :state) AND " +
            "(:city IS NULL OR u.city = :city) AND " +
            "(:age IS NULL OR u.age = :age)")
    Page<User> findByDynamicFilter(
            @Param("gender") String gender,
            @Param("nationality") String nationality,
            @Param("country") String country,
            @Param("state") String state,
            @Param("city") String city,
            @Param("age") Byte age,
            Pageable pageable
    );
}