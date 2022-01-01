package com.example.collections.util;

import com.example.collections.dto.PersonDTO;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Slf4j
public class ShortListDemo {

    public static void main(String[] args) {

        PersonDTO personA = new PersonDTO("Pedro", "Perez", 20);
        PersonDTO personB = new PersonDTO("Zaira", "Alvarez", 50);
        PersonDTO personC = new PersonDTO("Ana", "Blanco", 15);
        PersonDTO personD = new PersonDTO("Miguel", "Alvarez", 50);
        PersonDTO personE = new PersonDTO("Beatriz", "Gonzalez", 50);

        List<PersonDTO> personList = Arrays.asList(personA, personB, personC, personD, personE);
        log.info("Unsorted list ");
        personList.forEach(p -> log.info(p.getName()));

        sortWithLambda(personList);
    }

    private static void sortWithComparator(List<PersonDTO> personList) {

        Comparator<PersonDTO> sortByPersonName = (PersonDTO person1, PersonDTO person2) -> person1.getName().compareTo(person2.getName());
        personList.sort(sortByPersonName);

        log.info("List sorted {}",personList);
    }

    private static void sortWithLambda(List<PersonDTO> personList) {

        personList.sort((PersonDTO person1, PersonDTO person2) -> person1.getName().compareTo(person2.getName()));

        log.info("Sorted list ");
        personList.forEach(p -> log.info(p.getName()));
    }
}
