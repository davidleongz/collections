package com.example.collections.util;

import com.example.collections.dto.PersonDTO;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class SortListDemo {

    private static List<PersonDTO> personList;

    public static void main(String[] args) {

        PersonDTO personA = new PersonDTO("Pedro", "Perez", 20);
        PersonDTO personB = new PersonDTO("Zaira", "Alvarez", 50);
        PersonDTO personC = new PersonDTO("Ana", "Blanco", 15);
        PersonDTO personD = new PersonDTO("Miguel", "Alvarez", 50);
        PersonDTO personE = new PersonDTO("Beatriz", "Gonzalez", 50);

        List<PersonDTO> personList = Arrays.asList(personA, personB, personC, personD, personE);
        log.info("Unsorted list ");
        personList.forEach(p -> log.info(p.getName()));
        log.info("----------");

        setValuesToAllList(personList);

/*        sortListByFieldWithComparatorComparing(personList);
        sortListByFieldWithComparatorComparingReversedOrder(personList);
        sortListByFieldWithComparatorAndLambda(personList);
        sortListByFieldWithLambda(personList);
        sortListByFieldWithCollections(personList);
        sortNumberListNaturalOrder();
        sortNumberListReversedOrder();
        sortNumberListWithCollectionsReversedOrder();
        sortNumberListWithComparatorNaturalOrder();*/
    }

    private static void sortListByFieldWithComparatorComparing(List<PersonDTO> personList) {

        personList.sort(Comparator.comparing(PersonDTO::getName));

        log.info("Sorted list with Comparator.comparing");
        personList.forEach(p -> log.info(p.getName()));
    }


    private static void sortListByFieldWithComparatorComparingReversedOrder(List<PersonDTO> personList) {

        personList.sort(Comparator.comparing(PersonDTO::getName).reversed());

        log.info("Sorted list with Comparator.comparing and Reverse order");
        personList.forEach(p -> log.info(p.getName()));
    }


    private static void sortListByFieldWithComparatorAndLambda(List<PersonDTO> personList) {

        Comparator<PersonDTO> sortByPersonName = (PersonDTO person1, PersonDTO person2) -> person1.getName().compareTo(person2.getName());
        personList.sort(sortByPersonName);

        log.info("Sorted list With Comparator And Lambda");
        personList.forEach(p -> log.info(p.getName()));
    }

    private static void sortListByFieldWithLambda(List<PersonDTO> personList) {

        personList.sort((PersonDTO person1, PersonDTO person2) -> person1.getName().compareTo(person2.getName()));

        log.info("Sorted list with Lambda");
        personList.forEach(p -> log.info(p.getName()));
    }

    private static void sortListByFieldWithCollections(List<PersonDTO> personList) {

        Collections.sort(personList, (PersonDTO person1, PersonDTO person2) -> person1.getName().compareTo(person2.getName()));

        log.info("Sorted list with Collections package");
        personList.forEach(p -> log.info(p.getName()));
    }


    private static void sortNumberListWithCollectionsReversedOrder(){

        List<Integer> list = Arrays.asList(10, 4, 2, 6, 5, 8);
        log.info("Unsorted list number {}", list);

        Collections.sort(list, Collections.reverseOrder());

        log.info("Sorted list {}", list);
    }

    private static void sortNumberListNaturalOrder(){

        List<Integer> list = Arrays.asList(10, 4, 2, 6, 5, 8);
        log.info("Unsorted list number {}", list);

        list = list.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());

        log.info("Sorted list {}", list);
    }

    private static void sortNumberListReversedOrder(){

        List<Integer> list = Arrays.asList(10, 4, 2, 6, 5, 8);
        log.info("Unsorted list number {}", list);

        list = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        log.info("Sorted list {}", list);
    }

    private static void sortNumberListWithComparatorNaturalOrder(){

        List<Integer> list = Arrays.asList(10, 4, 2, 6, 5, 8);
        log.info("Unsorted list number {}", list);

        list.sort(Comparator.naturalOrder());

        log.info("Sorted list {}", list);
    }

    private static void setValuesToAllList(List<PersonDTO> personList){
        SortListDemo.personList = personList;

        personList.forEach(p -> {
                p.setAge(30);
                p.setName("Nombre1");
        });

        personList.forEach(p -> p.setSurName("Martinez"));

        log.info("Sorted list {}", personList);
    }

}
