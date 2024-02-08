package com.bank.service;

import com.bank.constant.BankConstant;
import com.bank.entity.CustomerRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {
    private final RestTemplate restTemplate;

    public CustomerService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public String create(CustomerRequest customerRequest) {
        // Call Customer API
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(
                BankConstant.CUSTOMER_URL, customerRequest, String.class);
        return responseEntity.getBody();

    }

    public Boolean validateCustomer(final Long customerId) {
        // Call Customer API
        ResponseEntity<Boolean> responseEntity = restTemplate.getForEntity(
                String.format("%s/%d", BankConstant.CUSTOMER_URL, customerId), Boolean.class);
        return responseEntity.getBody();
    }



}
