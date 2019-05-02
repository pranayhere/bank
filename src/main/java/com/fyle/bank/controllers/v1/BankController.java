package com.fyle.bank.controllers.v1;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fyle.bank.models.BankBranches;
import com.fyle.bank.models.Branch;
import com.fyle.bank.services.BankService;

import org.springframework.beans.factory.annotation.Autowired;
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

    // http://localhost:8080/api/v1/bank/branch?bankname=ABHYUDAYA%20COOPERATIVE%20BANK%20LIMITED&city=MUMBAI
    @GetMapping("/bank/branch")
    public List<BankBranches> getBranchesByCity(@RequestParam("bankname") String name, @RequestParam("city") String city) {
        try {
            return bankService.getBranchesByCity(name.toUpperCase(), city.toUpperCase());
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    
    // http://localhost:8080/api/v1/branch/ABHY00650028989898989
    @GetMapping("/branch/{ifsc}")
    public Branch getBranch(@PathVariable("ifsc") @NotBlank @Size(max = 11) String ifsc) {
        try {
            return bankService.getBranch(ifsc.toUpperCase());
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}