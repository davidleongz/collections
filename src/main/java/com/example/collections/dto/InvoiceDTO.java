package com.example.collections.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class InvoiceDTO {

    private String invoiceNumber;

    private String productDescription;

    private String unitPrice;

    private int quantity;

    private BigDecimal totalAmount;

    private Double totalAmountTest;

    public InvoiceDTO(String invoiceNumber, BigDecimal totalAmount) {
        this.invoiceNumber = invoiceNumber;
        this.totalAmount = totalAmount;
    }

    public InvoiceDTO(String invoiceNumber, Double totalAmountTest) {
        this.invoiceNumber = invoiceNumber;
        this.totalAmountTest = totalAmountTest;
    }
}
