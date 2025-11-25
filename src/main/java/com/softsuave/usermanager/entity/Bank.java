package com.softsuave.usermanager.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "banks")
@Getter
@Setter
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;

    @Column(length = 50)
    private String swift;

    @Column(nullable = false, length = 100)
    private String bankName;

    @Column(length = 100)
    private String branchName;

    @Column(length = 50)
    private String branchCode;

    @Column(length = 10)
    private String currency;

    @Column(length = 255)
    private String bankAddress;

    @Column(length = 50)
    private String city;

    @Column(length = 50)
    private String state;

    @Column(length = 50)
    private String country;

    private Long pinCode;

    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Account> accounts = new ArrayList<>();

    public Bank() {}

    public void addAccount(Account account) {
        accounts.add(account);
        account.setBank(this);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
        account.setBank(null);
    }
}