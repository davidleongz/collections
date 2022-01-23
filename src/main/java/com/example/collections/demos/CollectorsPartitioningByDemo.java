package com.example.collections.demos;

import com.example.collections.dto.PersonDTO;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class CollectorsPartitioningByDemo {

    public static void main(String[] args) {

        List<PersonDTO> personList = new ArrayList<PersonDTO>();
        personList.add(new PersonDTO("Pedro", "Lopez", 20));
        personList.add(new PersonDTO("Maria", "Pérez", 50));
        personList.add(new PersonDTO("Gema", "Sánchez", 70));
        personList.add(new PersonDTO("Ana", "Jiménez", 15));
        personList.add(new PersonDTO("David", "Almeida", 75));
        personList.add(new PersonDTO("Mar", "Santos", 70));

        Map<Boolean, List<PersonDTO>> map = personList.stream().collect(Collectors.partitioningBy(PersonDTO::isRetired));

        map.get(true).stream().map(PersonDTO::getName).forEach(n -> log.info(n + " is retired, medicine is free"));

        log.info("***********************");

        map.get(false).stream().map(PersonDTO::getName).forEach(n -> log.info(n + " need to pay"));

    }
}
