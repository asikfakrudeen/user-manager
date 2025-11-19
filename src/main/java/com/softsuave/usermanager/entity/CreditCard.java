package com.softsuave.usermanager.entity;

import com.softsuave.usermanager.enums.CardNetwork;
import com.softsuave.usermanager.enums.CardType;

import java.time.LocalDate;

public class CreditCard {

    private String cardNumber;
    private LocalDate issueDate;
    private LocalDate expiryDate;
    private String cvv;
    private CardNetwork cardNetwork;
    private String bankName;
    private CardType cardType;
    private boolean hasEmvChip;
    private boolean hasMagneticStripe;
    private boolean isContactlessEnabled;
    private String linkedAccountNumber;
    private double creditLimit;
    private double availableCredit;
    private String billingCycle;
    private double interestRateApr;

    public CreditCard() {}

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

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
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

    public String getLinkedAccountNumber() {
        return linkedAccountNumber;
    }

    public void setLinkedAccountNumber(String linkedAccountNumber) {
        this.linkedAccountNumber = linkedAccountNumber;
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
                "cardNumber='" + cardNumber + '\'' +
                ", issueDate=" + issueDate +
                ", expiryDate=" + expiryDate +
                ", cvv='" + cvv + '\'' +
                ", cardNetwork=" + cardNetwork +
                ", bankName='" + bankName + '\'' +
                ", cardType=" + cardType +
                ", creditLimit=" + creditLimit +
                ", availableCredit=" + availableCredit +
                ", hasEmvChip=" + hasEmvChip +
                ", hasMagneticStripe=" + hasMagneticStripe +
                ", isContactlessEnabled=" + isContactlessEnabled +
                ", billingCycle='" + billingCycle + '\'' +
                ", interestRateApr=" + interestRateApr +
                '}';
    }
}