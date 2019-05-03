package com.fyle.bank.controllers.v1;

import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fyle.bank.models.BankBranches;
import com.fyle.bank.models.Branch;
import com.fyle.bank.services.BankService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@Validated
@RequestMapping("/api/v1")
public class BankController {

    @Autowired
    BankService bankService;

    // http://localhost:5000/api/v1/bank/branches?bankname=ABHYUDAYA%20COOPERATIVE%20BANK%20LIMITED&city=MUMBAI&page=1&size=2
    @GetMapping("/bank/branches")
    public Page<BankBranches> getBranchesByCity(@RequestParam("bankname") String name, @RequestParam("city") String city, Pageable p) {
        try {
            return bankService.getPaginatedBranchesByCity(name.toUpperCase(), city.toUpperCase(), p);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
     }

    // http://localhost:5000/api/v1/branch/ABHY0065002
    @GetMapping("/branch/{ifsc}")
    public Branch getBranch(@PathVariable("ifsc") @NotBlank @Size(min = 11, max = 11) String ifsc) {
        try {
            return bankService.getBranch(ifsc.toUpperCase());
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}