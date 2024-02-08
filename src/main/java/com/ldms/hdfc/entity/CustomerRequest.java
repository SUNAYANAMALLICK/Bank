package com.ldms.hdfc.entity;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerRequest {
    private Long customerId;
    private String name;
    private LocalDateTime dateOfBirth;
    private String title;


}
