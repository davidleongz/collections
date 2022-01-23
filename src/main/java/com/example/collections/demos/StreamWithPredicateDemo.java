package com.example.collections.demos;

import com.example.collections.dto.InvoiceDTO;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Slf4j
public class StreamWithPredicateDemo {

    public static void main(String[] args) {

        List<InvoiceDTO> invoiceList = new ArrayList<InvoiceDTO>();
        invoiceList.add(new InvoiceDTO("1", BigDecimal.valueOf(1200)));
        invoiceList.add(new InvoiceDTO("2", BigDecimal.valueOf(350)));
        invoiceList.add(new InvoiceDTO("3", BigDecimal.valueOf(800)));
        invoiceList.add(new InvoiceDTO("4", BigDecimal.valueOf(3400)));
        invoiceList.add(new InvoiceDTO("5", BigDecimal.valueOf(750)));
        invoiceList.add(new InvoiceDTO("6", BigDecimal.valueOf(1500)));
        invoiceList.add(new InvoiceDTO("7", BigDecimal.valueOf(450)));
        invoiceList.add(new InvoiceDTO("8", BigDecimal.valueOf(150)));
        invoiceList.add(new InvoiceDTO("9", BigDecimal.valueOf(880)));
        invoiceList.add(new InvoiceDTO("10", BigDecimal.valueOf(990)));
        invoiceList.add(new InvoiceDTO("11", BigDecimal.valueOf(565)));

        getTotalAmountWithTaxesGreaterThan550AndLessThan1100withStream(invoiceList);
    }

    private static void getTotalAmountWithTaxesGreaterThan550AndLessThan1100withStream(List<InvoiceDTO> invoiceList) {

        Predicate<InvoiceDTO> isGreaterThan550 = invoice -> invoice.getTotalAmount().compareTo(BigDecimal.valueOf(550)) > 0;
        Predicate<InvoiceDTO> isLessThan1100 = invoice -> invoice.getTotalAmount().compareTo(BigDecimal.valueOf(1100)) < 0;
        Predicate<InvoiceDTO> isGreaterThan550AndIsLessThan1100 = isGreaterThan550.and(isLessThan1100);

        List<InvoiceDTO> invoiceListFiltered = invoiceList.stream().filter(isGreaterThan550AndIsLessThan1100).collect(Collectors.toList());

        List<BigDecimal> amountList = invoiceList.stream().filter(isGreaterThan550AndIsLessThan1100)
                .map(InvoiceDTO::getTotalAmount).collect(Collectors.toList());

        log.info("Invoices filtered: {}", amountList);
    }

}
