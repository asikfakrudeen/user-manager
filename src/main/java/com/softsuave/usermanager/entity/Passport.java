package com.softsuave.usermanager.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Passport {

    private BigDecimal passportNumber;
    private LocalDateTime dateOfIssue;
    private LocalDateTime dateOfExpiration;
    private String placeOfIssue;
    private String issuingAuthority;
}