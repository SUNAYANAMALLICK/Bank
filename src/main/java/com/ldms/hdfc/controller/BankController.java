package com.ldms.hdfc.controller;

import com.ldms.hdfc.entity.CustomerRequest;
import com.ldms.hdfc.entity.LoanRequest;
import com.ldms.hdfc.service.BankService;
import com.ldms.hdfc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

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
}
