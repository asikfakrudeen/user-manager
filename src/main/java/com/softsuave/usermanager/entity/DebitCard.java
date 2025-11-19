package com.softsuave.usermanager.entity;

import com.softsuave.usermanager.enums.CardNetwork;
import com.softsuave.usermanager.enums.CardType;

import java.time.LocalDate;

public class DebitCard {

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
    private double maximumWithdraw;
    private double availableBalance;

    public DebitCard() {}

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
}