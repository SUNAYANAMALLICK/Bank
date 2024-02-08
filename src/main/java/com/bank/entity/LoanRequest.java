package com.bank.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoanRequest {
    private Long loanId;
    //Number 3 Y Unique identifier of the loans record
    private Long customerId;
    // Number 3 Y Identifier of the Customer linked to the Loan
    private Long loanProductId;
    //   Number 3 Y Identify the type of loan from available Loan Product Types
    private Long openingBalance;
    //Number 10,2 Y Opening Balance on the loan
    private Long currentBalance;
    //Number 10,2 Y Current remaining balance to repay
    private Long paymentAmount;
    // Number 10,2 Y Amount to pay back in each repayment instalment
    private LocalDateTime paymentDate;
    // Date Y Date of repayment
    private Long rate;


}
