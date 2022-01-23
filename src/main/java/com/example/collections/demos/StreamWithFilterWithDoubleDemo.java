package com.example.collections.demos;

import com.example.collections.dto.InvoiceDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.BooleanUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class StreamWithFilterWithDoubleDemo {

    public static void main(String[] args) {

        List<InvoiceDTO> invoiceList = new ArrayList<InvoiceDTO>();
        invoiceList.add(new InvoiceDTO("1", Double.valueOf(1200)));
        invoiceList.add(new InvoiceDTO("2", Double.valueOf(350)));
        invoiceList.add(new InvoiceDTO("3", Double.valueOf(800)));
        invoiceList.add(new InvoiceDTO("4", Double.valueOf(3400)));
        invoiceList.add(new InvoiceDTO("5", Double.valueOf(750)));
        invoiceList.add(new InvoiceDTO("6", Double.valueOf(1500)));

        Boolean isSaved = null;

        try {
            if(isSaved){
                log.info("Paso1");
            }else{
                log.info("Paso2");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        getTotalAmountWithTaxesLessThan1000withStream(invoiceList);
    }

    private static void getTotalAmountWithTaxesLessThan1000withStream(List<InvoiceDTO> invoiceList) {

        Double totalAmountWithTaxes = invoiceList.stream().map(amount ->
                amount.getTotalAmountTest()*(Double.valueOf(1.21)))
                .filter(amount -> amount.compareTo(Double.valueOf(1000)) < 0)
                .mapToDouble(amount -> amount.doubleValue()).sum();

        log.info("Invoice total amount with Stream: {}", totalAmountWithTaxes);
    }

}
