package com.softsuave.usermanager.entity;

import com.softsuave.usermanager.enums.AccountStatus;
import com.softsuave.usermanager.enums.AccountType;

import java.util.List;

public class Account {

    private String accountNumber;
    private String accountHolderName;
    private AccountType accountType;
    private AccountStatus accountStatus;
    private Double balance;
    private String accountOpeningDate;

    private Bank bankDetails;
    private List<CreditCard> creditCardDetails;
    private List<DebitCard> debitCardDetails;

    public Account() {}

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getAccountOpeningDate() {
        return accountOpeningDate;
    }

    public void setAccountOpeningDate(String accountOpeningDate) {
        this.accountOpeningDate = accountOpeningDate;
    }

    public Bank getBankDetails() {
        return bankDetails;
    }

    public void setBankDetails(Bank bankDetails) {
        this.bankDetails = bankDetails;
    }

    public List<CreditCard> getCreditCardDetails() {
        return creditCardDetails;
    }

    public void setCreditCardDetails(List<CreditCard> creditCardDetails) {
        this.creditCardDetails = creditCardDetails;
    }

    public List<DebitCard> getDebitCardDetails() {
        return debitCardDetails;
    }

    public void setDebitCardDetails(List<DebitCard> debitCardDetails) {
        this.debitCardDetails = debitCardDetails;
    }
}