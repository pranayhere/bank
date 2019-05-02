package com.fyle.bank.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;

@Entity
@Getter @Setter
@Table(name = "branches")
public class Branch {
    @Id
    private String ifsc;
    
    @Getter(AccessLevel.NONE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_id", nullable = false)
    private Bank bank;

    private String branch; 
    private String address; 
    private String city;
    private String district; 
    private String state;
}