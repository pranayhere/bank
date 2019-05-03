package com.fyle.bank.repositories;

import com.fyle.bank.models.BankBranches;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankBranchesRepository extends JpaRepository<BankBranches, String> {
    Page<BankBranches> findAllByBankNameAndCity(String bankName, String city, Pageable pageable);
}