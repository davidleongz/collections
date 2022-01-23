package com.example.collections.demos;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.internal.collections.Ints.asList;

@Slf4j
public class PrimitiveAndObjectReferenceDemo {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(4, 8, 15, 16, 23, 42);
        log.info("List complete {}", list);

        removeItemListByIntPrimitiveValue();
        removeItemListByObject();
    }

    private static void removeItemListByIntPrimitiveValue() {
        Integer four = 4;
        List<Integer> numList = new ArrayList<>(asList(4, 8, 15, 16, 23, 42));
        numList.remove(four);
        log.info("List wit element removed finding value {}", numList);
    }

    private static void removeItemListByObject() {
        List<Integer> nums = new ArrayList<>(asList(4, 8, 15, 16, 23, 42));
        nums.remove(4);
        log.info("List wit element removed by index {}", nums);
    }

}
