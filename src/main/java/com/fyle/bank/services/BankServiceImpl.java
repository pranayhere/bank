package com.fyle.bank.services;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotBlank;

import com.fyle.bank.models.BankBranches;
import com.fyle.bank.models.Branch;
import com.fyle.bank.repositories.BankBranchesRepository;
import com.fyle.bank.repositories.BranchRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankServiceImpl implements BankService {

    @Autowired
    BranchRepository branchRepository;

    @Autowired
    BankBranchesRepository bankBranchesRepository;
    
    @Override
    public Branch getBranch(@NotBlank String ifsc) {
        Optional<Branch> branch = branchRepository.findById(ifsc);
        if (!branch.isPresent())
            throw new RuntimeException("No Branch associated with ifsc code");
        return branch.get();
    }


    @Override
    public List<BankBranches> getBranchesByCity(@NotBlank String name, @NotBlank String city) {
        List<BankBranches> bankBranches = bankBranchesRepository.findByBankNameAndCity(name, city);

        if (bankBranches.isEmpty())
            throw new RuntimeException("No Branches for the Bank in the given city");
        
        return bankBranches;
    }
}