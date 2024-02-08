package com.ldms.hdfc.service;

import com.ldms.hdfc.entity.LoanRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.ldms.hdfc.constant.BankConstant.LOAN_URL;
@Service
public class LoanService {

    private final RestTemplate restTemplate;
    @Autowired
    CustomerService customerService;

    public LoanService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String requestLoan(LoanRequest loanRequest) {

        String url = "http://localhost:8086/api/v1/loan";
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(
                LOAN_URL, loanRequest, String.class);
        return responseEntity.getBody();
    }
}
