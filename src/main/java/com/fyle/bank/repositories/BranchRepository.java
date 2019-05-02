package com.fyle.bank.repositories;

import com.fyle.bank.models.Branch;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, String> {
}