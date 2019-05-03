package com.fyle.bank.services;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotBlank;

import com.fyle.bank.models.BankBranches;
import com.fyle.bank.models.Branch;
import com.fyle.bank.repositories.BankBranchesRepository;
import com.fyle.bank.repositories.BranchRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<BankBranches> getPaginatedBranchesByCity(@NotBlank String name, @NotBlank String city, Pageable pageable) {
        return getBranchesByCity(name, city, pageable);
    }

    @Override
    public List<BankBranches> getAllBranchesByCity(@NotBlank String name, @NotBlank String city) {
        return getBranchesByCity(name, city, null).getContent();
    }

    private Page<BankBranches> getBranchesByCity(String name, String city, Pageable pageable) {
        Page<BankBranches> bankBranches = bankBranchesRepository.findAllByBankNameAndCity(name, city, pageable);

        if (bankBranches.isEmpty())
            throw new RuntimeException("No Branches for the Bank in the given city");
        
        return bankBranches;
    }
}