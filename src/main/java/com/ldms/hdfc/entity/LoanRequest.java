package com.ldms.hdfc.entity;

import java.time.LocalDateTime;

public class LoanRequest {
    private Long loanId;
    //Number 3 Y Unique identifier of the loans record
    private Integer customerId;
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

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Long getLoanProductId() {
        return loanProductId;
    }

    public void setLoanProductId(Long loanProductId) {
        this.loanProductId = loanProductId;
    }

    public Long getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(Long openingBalance) {
        this.openingBalance = openingBalance;
    }

    public Long getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Long currentBalance) {
        this.currentBalance = currentBalance;
    }

    public Long getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Long paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Long getRate() {
        return rate;
    }

    public void setRate(Long rate) {
        this.rate = rate;
    }
}
