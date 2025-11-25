package com.softsuave.usermanager.entity;

import com.softsuave.usermanager.enums.AccountStatus;
import com.softsuave.usermanager.enums.AccountType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "accounts")
@Getter
@Setter
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
    private Customer customer;

    // account belongs to a bank/branch
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
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

    public void addDebitCard(DebitCard card) {
        debitCardDetails.add(card);
        card.setLinkedAccount(this);
        if (card.getOwner() == null) card.setOwner(this.customer);
    }
}