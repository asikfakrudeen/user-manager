package com.softsuave.usermanager.entity;

import com.softsuave.usermanager.enums.CardNetwork;
import com.softsuave.usermanager.enums.CardType;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "credit_cards")
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

    // reference Bank if needed (otherwise you can keep bankName)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_id")
    private Bank bank;

    @Enumerated(EnumType.STRING)
    private CardType cardType;

    private boolean hasEmvChip;
    private boolean hasMagneticStripe;
    private boolean isContactlessEnabled;

    // Owning side -> many cards to one account
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account linkedAccount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private User owner;

    private double creditLimit;
    private double availableCredit;
    private String billingCycle;
    private double interestRateApr;

    public CreditCard() {}

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

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public double getAvailableCredit() {
        return availableCredit;
    }

    public void setAvailableCredit(double availableCredit) {
        this.availableCredit = availableCredit;
    }

    public String getBillingCycle() {
        return billingCycle;
    }

    public void setBillingCycle(String billingCycle) {
        this.billingCycle = billingCycle;
    }

    public double getInterestRateApr() {
        return interestRateApr;
    }

    public void setInterestRateApr(double interestRateApr) {
        this.interestRateApr = interestRateApr;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
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
                ", creditLimit=" + creditLimit +
                ", availableCredit=" + availableCredit +
                ", billingCycle='" + billingCycle + '\'' +
                ", interestRateApr=" + interestRateApr +
                '}';
    }
}