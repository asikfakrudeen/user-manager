package com.softsuave.usermanager.entity;

import com.softsuave.usermanager.enums.AccountStatus;
import com.softsuave.usermanager.enums.AccountType;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;

    @Column(nullable = false, unique = true)
    private String accountNumber;

    private String accountHolderName;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    private Double balance;
    private String accountOpeningDate;

    // central: account belongs to a user (customer)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private User customer;

    // account belongs to a bank/branch
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_id")
    private Bank bank;

    // cards linked to this account (optional: user may own card but card linked to account)
    @OneToMany(mappedBy = "linkedAccount", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<CreditCard> creditCardDetails = new ArrayList<>();

    @OneToMany(mappedBy = "linkedAccount", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<DebitCard> debitCardDetails = new ArrayList<>();

    public Account() {}

    public void addCreditCard(CreditCard card) {
        creditCardDetails.add(card);
        card.setLinkedAccount(this);
        if (card.getOwner() == null) card.setOwner(this.customer);
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

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