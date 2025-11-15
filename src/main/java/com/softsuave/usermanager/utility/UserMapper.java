package com.softsuave.usermanager.utility;

import com.softsuave.usermanager.dto.UserRequest;
import com.softsuave.usermanager.dto.UserResponse;
import com.softsuave.usermanager.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapToUserEntity(UserRequest dto){
        User user = new User();
        user.setPin(dto.getPin());
        user.setFirstNAme(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setGender(dto.getGender());
        user.setAge(dto.getAge());
        user.setGmail(dto.getGmail());
        user.setMobileNumber(dto.getMobileNumber());
        user.setDateOfBirth(dto.getDateOfBirth());
        user.setNationality(dto.getNationality());
        user.setCountry(dto.getCountry());
        user.setState(dto.getState());
        user.setCity(dto.getCity());
        return user;
    }

    public UserResponse mapToUserResponse(User user){
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setPermanentIdentificationNumber(user.getPin());
        userResponse.setFullName(fullNameSetter(user));
        userResponse.setGmail(user.getGmail());
        userResponse.setMobileNumber(user.getMobileNumber());
        userResponse.setDescription(descriptionSetter(user));
        return userResponse;
    }

    public String fullNameSetter(User user){
        return user.getFirstName() + " " + user.getLastName();
    }

    public String descriptionSetter(User user){
        return "%s is a %d-years old %s %s residing in %s, %s."
                .formatted(fullNameSetter(user),user.getAge(), user.getNationality(), user.getGender(), user.getCity(), user.getState());
    }
}