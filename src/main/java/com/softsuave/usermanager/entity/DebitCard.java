package com.softsuave.usermanager.entity;

import com.softsuave.usermanager.enums.CardNetwork;
import com.softsuave.usermanager.enums.CardType;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "debit_cards")
public class DebitCard {

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_id")
    private Bank bank;

    @Enumerated(EnumType.STRING)
    private CardType cardType;

    private boolean hasEmvChip;
    private boolean hasMagneticStripe;
    private boolean isContactlessEnabled;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account linkedAccount;

    private double maximumWithdraw;
    private double availableBalance;

    // inside DebitCard.java
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private User owner;

    public DebitCard() {}

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public CardNetwork getCardNetwork() {
        return cardNetwork;
    }

    public void setCardNetwork(CardNetwork cardNetwork) {
        this.cardNetwork = cardNetwork;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public boolean isHasEmvChip() {
        return hasEmvChip;
    }

    public void setHasEmvChip(boolean hasEmvChip) {
        this.hasEmvChip = hasEmvChip;
    }

    public boolean isHasMagneticStripe() {
        return hasMagneticStripe;
    }

    public void setHasMagneticStripe(boolean hasMagneticStripe) {
        this.hasMagneticStripe = hasMagneticStripe;
    }

    public boolean isContactlessEnabled() {
        return isContactlessEnabled;
    }

    public void setContactlessEnabled(boolean contactlessEnabled) {
        isContactlessEnabled = contactlessEnabled;
    }

    public Account getLinkedAccount() {
        return linkedAccount;
    }

    public void setLinkedAccount(Account linkedAccount) {
        this.linkedAccount = linkedAccount;
    }

    public double getMaximumWithdraw() {
        return maximumWithdraw;
    }

    public void setMaximumWithdraw(double maximumWithdraw) {
        this.maximumWithdraw = maximumWithdraw;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }

    @Override
    public String toString() {
        return "DebitCard{" +
                "id='" + id + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", issueDate=" + issueDate +
                ", expiryDate=" + expiryDate +
                ", cvv='" + cvv + '\'' +
                ", cardNetwork=" + cardNetwork +
                ", bank=" + bank +
                ", cardType=" + cardType +
                ", hasEmvChip=" + hasEmvChip +
                ", hasMagneticStripe=" + hasMagneticStripe +
                ", isContactlessEnabled=" + isContactlessEnabled +
                ", linkedAccount=" + linkedAccount +
                ", maximumWithdraw=" + maximumWithdraw +
                ", availableBalance=" + availableBalance +
                '}';
    }
}