package com.fyle.bank.services;

import java.util.List;

import com.fyle.bank.models.BankBranches;
import com.fyle.bank.models.Branch;

public interface BankService {
    Branch getBranch(String ifsc);
    List<BankBranches> getBranchesByCity(String name, String city);
}