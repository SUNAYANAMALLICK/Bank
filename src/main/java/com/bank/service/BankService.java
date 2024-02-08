package com.bank.service;

import com.bank.entity.LoanRequest;
import com.bank.exception.ValidationException;
import com.bank.entity.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService {

    @Autowired
    CustomerService customerService;

    @Autowired
    LoanService loanService;


    public String create(CustomerRequest customerRequest) {
        return customerService.create(customerRequest);
    }

    public String request(LoanRequest loanRequest) {
        if (null == loanRequest.getCustomerId() || null == customerService.validateCustomer(loanRequest.getCustomerId())) {
            throw new ValidationException(String.format(" Invalid Customer Id Given. <%s>", loanRequest.getCustomerId()));
        }
        return loanService.requestLoan(loanRequest);
    }

    public List<LoanRequest> find(Long customerId) {
        if(customerService.validateCustomer(customerId)){
           return loanService.getLoans(customerId);
        }else{
            throw new ValidationException(String.format(" Invalid Customer Id Given. <%s>", customerId));
        }

    }
}
