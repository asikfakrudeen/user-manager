package com.softsuave.usermanager.entity;

import java.util.List;

public class Banking {

    private String bankName;
    private String accountHolderName;
    private String bankAccountNumber;
    private String branchCode;
    private String accountType;
    private String currency;
    private String accountStatus;
    private String BankAddress;
    private String ContactInformation;
    private String accountOpeningDate;
    List<CreditCard> creditCardDetails;
    List<DebitCard> debitCardDetails;
}