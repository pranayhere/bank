package com.fyle.bank.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class BankBranches {
    @Id
    private String ifsc;
    private Long bankId;
    private String branch; 
    private String address; 
    private String city; 
    private String district; 
    private String state;
    private String bankName;
}