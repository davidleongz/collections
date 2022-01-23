package com.example.collections.demos;

import com.example.collections.dto.InvoiceDTO;
import com.example.collections.dto.PersonDTO;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

@Slf4j
public class OddEvenNumberAndDuplicatesDemo {

    private static List<PersonDTO> personList;

    public static void main(String[] args) {

        extractEvenNumbersOfList();
        removeDuplicateElementsFromListUsingStream();
        removeDuplicateItemsFromListUsingSet();
        removeDuplicateItemsByField();
        removeDuplicateItemsByFieldUsingSet();
    }

    private static void extractEvenNumbersOfList(){

        List<Integer> numberList = Arrays.asList(1,2,3,4,5,6);
        log.info("Complete list {}", numberList);

        List<Integer> evenNumberList = numberList.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        List<Integer> oddNumberList = numberList.stream().filter(n -> n % 2 != 0).collect(Collectors.toList());

        log.info("Even number list {}", evenNumberList);
        log.info("Odd number list {}", oddNumberList);
    }

    private static void removeDuplicateElementsFromListUsingStream(){

        List<Integer> numberRepeatedList = Arrays.asList(1,2,3,4,5,6,6,7,8,8,9);
        log.info("Complete list with repeated {}", numberRepeatedList);

        List<Integer> numberWithoutRepeatedList = numberRepeatedList.stream().distinct().collect(Collectors.toList());
        log.info("Complete list without repeated {}", numberWithoutRepeatedList);
    }

    private static void removeDuplicateItemsFromListUsingSet() {

        List<Integer> listWithDuplicates = Arrays.asList(5, 0, 3, 1, 2, 3, 0, 0);
        log.info("List with duplicates {}", listWithDuplicates);

        List<Integer> listWithoutDuplicates = new ArrayList<>(
                new HashSet<>(listWithDuplicates));

        log.info("List without duplicates {}", listWithoutDuplicates);

    }

    private static void removeDuplicateItemsByField(){

        List<InvoiceDTO> invoiceDuplicatesList = new ArrayList<InvoiceDTO>();
        invoiceDuplicatesList.add(new InvoiceDTO("1", BigDecimal.valueOf(1200)));
        invoiceDuplicatesList.add(new InvoiceDTO("1", BigDecimal.valueOf(350)));
        invoiceDuplicatesList.add(new InvoiceDTO("2", BigDecimal.valueOf(800)));
        invoiceDuplicatesList.add(new InvoiceDTO("3", BigDecimal.valueOf(3400)));
        invoiceDuplicatesList.add(new InvoiceDTO("3", BigDecimal.valueOf(750)));
        invoiceDuplicatesList.add(new InvoiceDTO("4", BigDecimal.valueOf(1300)));
        invoiceDuplicatesList.add(new InvoiceDTO("5", BigDecimal.valueOf(1400)));
        invoiceDuplicatesList.add(new InvoiceDTO("5", BigDecimal.valueOf(1500)));
        invoiceDuplicatesList.add(new InvoiceDTO("6", BigDecimal.valueOf(1600)));

        log.info("Invoices with ID duplicates");
        invoiceDuplicatesList.forEach(invoice -> log.info(invoice.getInvoiceNumber()));

        List<InvoiceDTO> invoiceWithoutDuplicatesList = invoiceDuplicatesList.stream()
                .collect(collectingAndThen(toCollection(() -> new TreeSet<>(comparing(InvoiceDTO::getInvoiceNumber))),
                        ArrayList::new));

        log.info("Invoices without ID duplicates");
        invoiceWithoutDuplicatesList.forEach(invoice -> log.info(invoice.getInvoiceNumber()));
    }


    private static void removeDuplicateItemsByFieldUsingSet(){

        List<InvoiceDTO> invoiceDuplicatesList = new ArrayList<InvoiceDTO>();
        invoiceDuplicatesList.add(new InvoiceDTO("1", BigDecimal.valueOf(1200)));
        invoiceDuplicatesList.add(new InvoiceDTO("1", BigDecimal.valueOf(350)));
        invoiceDuplicatesList.add(new InvoiceDTO("2", BigDecimal.valueOf(800)));
        invoiceDuplicatesList.add(new InvoiceDTO("3", BigDecimal.valueOf(3400)));
        invoiceDuplicatesList.add(new InvoiceDTO("3", BigDecimal.valueOf(750)));
        invoiceDuplicatesList.add(new InvoiceDTO("4", BigDecimal.valueOf(1300)));
        invoiceDuplicatesList.add(new InvoiceDTO("5", BigDecimal.valueOf(1400)));
        invoiceDuplicatesList.add(new InvoiceDTO("5", BigDecimal.valueOf(1500)));
        invoiceDuplicatesList.add(new InvoiceDTO("6", BigDecimal.valueOf(1600)));

        log.info("Invoices with ID duplicates using Set");
        invoiceDuplicatesList.forEach(invoice -> log.info(invoice.getInvoiceNumber()));

        Set<String> invoiceSet = new HashSet<>();
        List<InvoiceDTO> invoiceWithoutDuplicatesList = invoiceDuplicatesList.stream()
                .filter(e -> invoiceSet.add(e.getInvoiceNumber()))
                .collect(Collectors.toList());

        log.info("Invoices without ID duplicate using Set");
        invoiceWithoutDuplicatesList.forEach(invoice -> log.info(invoice.getInvoiceNumber()));
    }
}