package com.ldms.hdfc.service;

import com.ldms.hdfc.entity.CustomerRequest;
import com.ldms.hdfc.entity.LoanRequest;
import com.ldms.hdfc.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
