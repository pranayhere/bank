package com.fyle.bank.repositories;

import com.fyle.bank.models.Bank;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {
}