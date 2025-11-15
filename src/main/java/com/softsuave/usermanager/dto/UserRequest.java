package com.softsuave.usermanager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public class UserRequest {

    @JsonProperty("PIN")
    @NotNull(message = "PIN cannot be null")
    @Digits(integer = 10, fraction = 0, message = "Personal Identification Number must be 10 digits")
    private Long pin;

    @JsonProperty("firstName")
    @NotBlank(message = "First name is required")
    @Size(max = 50, message = "First name cannot exceed 50 characters")
    private String firstName;

    @JsonProperty("lastName")
    @NotBlank(message = "Last name is required")
    @Size(max = 50, message = "Last name cannot exceed 50 characters")
    private String lastName;

    @JsonProperty("gender")
    @NotBlank(message = "Gender is required")
    @Pattern(regexp = "Male|Female|Other", message = "Gender must be Male, Female, or Other")
    private String gender;

    @JsonProperty("age")
    @NotNull(message = "Age is required")
    @Min(value = 1, message = "Age cannot be negative")
    @Max(value = 99, message = "Age cannot exceed 99")
    private Byte age;

    @JsonProperty("gmail")
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String gmail;

    @JsonProperty("mobileNumber")
    @NotNull(message = "Mobile number is required")
    @Digits(integer = 10, fraction = 0, message = "Mobile number must be 10 digits")
    private Long mobileNumber;

    @JsonProperty("dateOfBirth")
    @NotNull(message = "Date of birth is required")
    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    @JsonProperty("nationality")
    @NotBlank(message = "Nationality is required")
    private String nationality;

    @JsonProperty("country")
    @NotBlank(message = "Country is required")
    private String country;

    @JsonProperty("state")
    @NotBlank(message = "State is required")
    private String state;

    @JsonProperty("city")
    @NotBlank(message = "City is required")
    private String city;

    public UserRequest() {}

    public Long getPin() {
        return pin;
    }

    public void setPin(Long pin) {
        this.pin = pin;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "UserRequest{" +
                "pin=" + pin +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", gmail='" + gmail + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", dateOfBirth=" + dateOfBirth +
                ", nationality='" + nationality + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}