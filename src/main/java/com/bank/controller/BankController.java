package com.bank.controller;

import com.bank.entity.CustomerRequest;
import com.bank.entity.LoanRequest;
import com.bank.exception.ValidationException;
import com.bank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.bank.constant.BankConstant.CUSTOMER_NOT_FOUND;
import static com.bank.constant.BankConstant.LOAN_NOT_FOUND;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/bank")

public class BankController {
    @Autowired
    BankService bankService;

    // New
    @PostMapping(value = "/customer")
    public ResponseEntity<String> createCustomer(@RequestBody  final CustomerRequest customerRequest){
        return new ResponseEntity<>(bankService.create(customerRequest), CREATED);
    }
    // Existing
    @PostMapping(value = "/loan")
    public ResponseEntity<String> requestLoan(@RequestBody  final LoanRequest loanRequest){
        return new ResponseEntity<>(bankService.request(loanRequest), CREATED);
    }

    @GetMapping(value = "/loan/{customerId}")
    public ResponseEntity<List<LoanRequest>> find(@PathVariable final Long customerId){
        List<LoanRequest> loans = bankService.find(customerId) ;
        if(loans.isEmpty()){
            throw new ValidationException(String.format("%s: %s",LOAN_NOT_FOUND, customerId));
        }
        return new ResponseEntity<>(loans , OK);
    }
}
