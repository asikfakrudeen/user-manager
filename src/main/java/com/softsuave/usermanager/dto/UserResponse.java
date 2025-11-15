package com.softsuave.usermanager.dto;

public class UserResponse {

    private String id;
    private Long permanentIdentificationNumber;
    private String fullName;
    private String gmail;
    private Long mobileNumber;
    private String description;

    public UserResponse() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getPermanentIdentificationNumber() {
        return permanentIdentificationNumber;
    }

    public void setPermanentIdentificationNumber(Long permanentIdentificationNumber) {
        this.permanentIdentificationNumber = permanentIdentificationNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "id='" + id + '\'' +
                ", permanentIdentificationNumber=" + permanentIdentificationNumber +
                ", fullName='" + fullName + '\'' +
                ", gmail='" + gmail + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", description='" + description + '\'' +
                '}';
    }
}