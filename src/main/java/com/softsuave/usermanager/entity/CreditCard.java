package com.softsuave.usermanager.entity;

import com.softsuave.usermanager.enums.CardNetwork;
import com.softsuave.usermanager.enums.CardType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "credit_cards")
@Getter
@Setter
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;

    @Column(nullable = false, unique = true)
    private String cardNumber;

    private LocalDate issueDate;
    private LocalDate expiryDate;
    private String cvv;

    @Enumerated(EnumType.STRING)
    private CardNetwork cardNetwork;

    @Enumerated(EnumType.STRING)
    private CardType cardType;

    private boolean hasEmvChip;
    private boolean hasMagneticStripe;
    private boolean isContactlessEnabled;

    private double creditLimit;
    private double availableCredit;
    private String billingCycle;
    private double interestRateApr;

    // Owning side -> many cards to one bank
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_id")
    private Bank bank;

    // Owning side -> many cards to one account
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account linkedAccount;

    // Owning side -> many cards to one owner
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private User owner;

    public CreditCard() {}
}