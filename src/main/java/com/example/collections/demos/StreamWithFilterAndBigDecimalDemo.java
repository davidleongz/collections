package com.example.collections.demos;

import com.example.collections.dto.InvoiceDTO;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class StreamWithFilterAndBigDecimalDemo {

    public static void main(String[] args) {

        List<InvoiceDTO> invoiceList = new ArrayList<InvoiceDTO>();
        invoiceList.add(new InvoiceDTO("1", BigDecimal.valueOf(1200)));
        invoiceList.add(new InvoiceDTO("2", BigDecimal.valueOf(350)));
        invoiceList.add(new InvoiceDTO("3", BigDecimal.valueOf(800)));
        invoiceList.add(new InvoiceDTO("4", BigDecimal.valueOf(3400)));
        invoiceList.add(new InvoiceDTO("5", BigDecimal.valueOf(750)));
        invoiceList.add(new InvoiceDTO("6", BigDecimal.valueOf(1500)));

        getInvoicesGreaterThan1200(invoiceList);

        log.info("***********************");

        getInvoiceWithAmount1500(invoiceList);

        log.info("***********************");

        getTotalAmountWithTaxesLessThan1000(invoiceList);

        log.info("***********************");

        getTotalAmountWithTaxesLessThan1000withStream(invoiceList);
    }

    private static void getTotalAmountWithTaxesLessThan1000withStream(List<InvoiceDTO> invoiceList) {

        BigDecimal totalAmountWithTaxes = invoiceList.stream().map(amount ->
                amount.getTotalAmount().multiply(BigDecimal.valueOf(1.21)))
                .filter(amount -> amount.compareTo(BigDecimal.valueOf(1000)) < 0)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        log.info("Invoice total amount with Stream: {}", totalAmountWithTaxes);
    }

    private static void getTotalAmountWithTaxesLessThan1000(List<InvoiceDTO> invoiceList) {

        BigDecimal totalAmountWithTaxes = BigDecimal.ZERO;

        for(InvoiceDTO invoiceDTO : invoiceList){

            BigDecimal amountWitTaxes = BigDecimal.ZERO;

            if(invoiceDTO.getTotalAmount().multiply(BigDecimal.valueOf(1.21)).compareTo(BigDecimal.valueOf(1000)) < 0 ){

                amountWitTaxes = amountWitTaxes.add(invoiceDTO.getTotalAmount().multiply(BigDecimal.valueOf(1.21)));
                totalAmountWithTaxes = totalAmountWithTaxes.add(amountWitTaxes);
                log.info("Invoice amount with taxes: {}", amountWitTaxes);
            }
        }

        log.info("Invoice total amount: {}", totalAmountWithTaxes);
    }

    private static void getInvoicesGreaterThan1200(List<InvoiceDTO> invoiceList) {

        List<InvoiceDTO> invoiceFilteredList = invoiceList.stream().filter(invoice ->
                invoice.getTotalAmount().compareTo(BigDecimal.valueOf(Double.valueOf(1200))) == 1).collect(Collectors.toList());

        invoiceFilteredList.forEach(f -> log.info("Invoice with amount: {}", f.getTotalAmount()));
    }


    private static void getInvoiceWithAmount1500(List<InvoiceDTO> invoiceList) {

        List<InvoiceDTO> invoiceFilteredList = invoiceList.stream().filter(invoice ->
                invoice.getTotalAmount().compareTo(BigDecimal.valueOf(Double.valueOf("1500"))) == 0).collect(Collectors.toList());

        invoiceFilteredList.forEach(f -> log.info("Invoice number {} with {}", f.getInvoiceNumber(), f.getTotalAmount()));
    }



}
