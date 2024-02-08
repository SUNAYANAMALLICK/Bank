package com.bank.service;

import com.bank.constant.BankConstant;
import com.bank.entity.LoanRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class LoanService {

    private final RestTemplate restTemplate;
    @Autowired
    CustomerService customerService;

    public LoanService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String requestLoan(LoanRequest loanRequest) {

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(
                BankConstant.LOAN_URL, loanRequest, String.class);
        return responseEntity.getBody();
    }

    public List<LoanRequest> getLoans(Long customerId) {

        ResponseEntity<List<LoanRequest>> responseEntity = restTemplate.exchange(
                String.format("%s/%d", BankConstant.LOAN_URL, customerId),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );

        return responseEntity.getBody();


    }
}
