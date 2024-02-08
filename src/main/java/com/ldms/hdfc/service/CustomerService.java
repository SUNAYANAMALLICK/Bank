package com.ldms.hdfc.service;

import com.ldms.hdfc.entity.CustomerRequest;
import com.ldms.hdfc.entity.LoanRequest;
import com.ldms.hdfc.exception.ValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.ldms.hdfc.constant.BankConstant.CUSTOMER_URL;

@Service
public class CustomerService {
    private final RestTemplate restTemplate;

    public CustomerService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public String create(CustomerRequest customerRequest) {
        // Call Customer API
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(
                CUSTOMER_URL, customerRequest, String.class);
        return responseEntity.getBody();

    }

    public String validateCustomer(final Integer customerId) {
        // Call Customer API
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(
                String.format("%s/%d",CUSTOMER_URL, customerId), String.class);
        return responseEntity.getBody();
    }



}
