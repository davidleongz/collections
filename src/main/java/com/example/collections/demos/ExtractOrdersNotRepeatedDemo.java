package com.example.collections.demos;

import com.example.collections.dto.OrderListDTO;
import com.example.collections.util.JsonTools;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Slf4j
public class ExtractOrdersNotRepeatedDemo {

    public static void main(String[] args) {

        OrderListDTO orderLargeList = JsonTools.convertJsonFileToObjecDto("json", "jsonLargeList.json",
                OrderListDTO.class);

        OrderListDTO orderSmallList = JsonTools.convertJsonFileToObjecDto("json", "jsonSmallList.json",
                OrderListDTO.class);

        findDifferencesWithRemoveAll(orderLargeList, orderSmallList);
        findDifferencesWithStreamAndPredicate(orderLargeList, orderSmallList);
        findDifferencesWithStreamAndFilter(orderLargeList, orderSmallList);
    }


    private static void findDifferencesWithStreamAndFilter(OrderListDTO orderLargeList, OrderListDTO orderSmallList) {
        List<String> ordersNotRepeated =
                orderLargeList.getOrderList()
                        .stream().filter(element -> !orderSmallList.getOrderList().contains(element)).collect(Collectors.toList());

        log.info("{} differences found using stream and filter: ", ordersNotRepeated.size());
    }


    private static void findDifferencesWithStreamAndPredicate(OrderListDTO orderLargeList, OrderListDTO orderSmallList) {

        List<String> ordersNotRepeated = orderLargeList.getOrderList().stream()
                .filter(Predicate.not(orderSmallList.getOrderList()::contains))
                .collect(Collectors.toList());

        log.info("{} differences found using stream, filter and predicate", ordersNotRepeated.size());
    }

    
    private static void findDifferencesWithRemoveAll(OrderListDTO orderLargeList, OrderListDTO orderSmallList) {

        orderLargeList.getOrderList().removeAll(orderSmallList.getOrderList());

        log.info("{} differences found", orderLargeList.getOrderList().size());
    }
}
