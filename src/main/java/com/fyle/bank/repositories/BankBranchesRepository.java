package com.fyle.bank.repositories;

import java.util.List;

import com.fyle.bank.models.BankBranches;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BankBranchesRepository extends JpaRepository<BankBranches, String> {
    List<BankBranches> findByBankNameAndCity(String bankName, String city);
}