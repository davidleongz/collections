package com.example.collections.demos;

import com.example.collections.dto.InvoiceDTO;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class StreamWithStringDemo {

    public static void main(String[] args) {

        String text = "name:Pedro,name:Gema,name:Ana";

        getNamesWithStream(text);
        getNamesWithStreamToList(text);
        mapToStringUsingCollectorsJoining();
        stringToUpperCaseUsingStream();
    }

    private static void stringToUpperCaseUsingStream() {
        List<String> letterList = Arrays.asList("a", "b", "c", "d");
        log.info("Letter list: {}", letterList);
        List<String> letterListUpperCase = letterList.stream().map(letter -> letter.toUpperCase()).collect(Collectors.toList());
        log.info("Letter list converted: {}", letterListUpperCase);

        List<String> listWithMethodReference = letterList.stream().map(String::toUpperCase).collect(Collectors.toList());
        log.info("Letter list converted using method reference: {}", listWithMethodReference);
    }

    private static void mapToStringUsingCollectorsJoining() {

        Map<Integer, String> wordsByKey = new HashMap<>();
        wordsByKey.put(1, "one");
        wordsByKey.put(2, "two");
        wordsByKey.put(3, "three");
        wordsByKey.put(4, "four");

        String mapAsString = wordsByKey.keySet().stream()
                .map(key -> key + "=" + wordsByKey.get(key))
                .collect(Collectors.joining(", ", "{", "}"));

        log.info("Result: {}", mapAsString);
    }

    private static void getNamesWithStreamToList(String text) {

        String[] names = text.split(Pattern.quote(","));
        log.info("Names {}", Arrays.asList(names));
        log.info("Names filtered {}", Arrays.stream(names).map(name -> name.substring(5, name.length())).collect(Collectors.toList()));
    }

    private static void getNamesWithStream(String text) {

        Stream<String> blocks = Pattern.compile(",").splitAsStream(text);
        blocks.map(name -> name.substring(5, name.length())).forEach(System.out::println);
    }


}
