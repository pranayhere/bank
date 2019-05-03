package com.fyle.bank.services;

import java.util.List;

import com.fyle.bank.models.BankBranches;
import com.fyle.bank.models.Branch;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BankService {
    Branch getBranch(String ifsc);
    Page<BankBranches> getBranchesByCity(String name, String city, Pageable p);
    List<BankBranches> getBranchesByCity(String name, String city);
    
}