package com.ldms.hdfc.service;

import com.ldms.hdfc.entity.CustomerRequest;
import com.ldms.hdfc.entity.LoanRequest;
import com.ldms.hdfc.exception.ValidationException;
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
        String url = "http://localhost:8085/api/v1/customer/";
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(
                url, customerRequest, String.class);
        return responseEntity.getBody();

    }

    public String validateCustomer(final Integer customerId) {
        // Call Customer API
        String url = String.format("http://localhost:8085/ldm/customer/%d", customerId);
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(
                url, String.class);
        return responseEntity.getBody();
    }



}
