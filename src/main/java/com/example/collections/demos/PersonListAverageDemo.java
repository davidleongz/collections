package com.example.collections.demos;

import com.example.collections.dto.PersonDTO;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class PersonListAverageDemo {

    public static void main(String[] args) {

        PersonDTO personA = new PersonDTO("Pedro", "Perez", 20);
        PersonDTO personB = new PersonDTO("Zaira", "Alvarez", 50);
        PersonDTO personC = new PersonDTO("Ana", "Blanco", 15);
        PersonDTO personD = new PersonDTO("Miguel", "Alvarez", 60);
        PersonDTO personE = new PersonDTO("Beatriz", "Gonzalez", 12);

        List<PersonDTO> personList = Arrays.asList(personA, personB, personC, personD, personE);

        System.out.println("Average Imperative Programming: " + getAverageImperativeProgramming(personList));
        System.out.println("Average Functional Programming: " + getAverageFunctionalProgramming(personList));
    }

    private static Integer getAverageImperativeProgramming(List<PersonDTO> personList) {

        Integer totalAge = 0;
        Integer totalPeople = 0;

        for (PersonDTO person : personList){
            if(person.getAge() >= 18){
                totalAge += person.getAge();
                totalPeople++;
            }
        }

        return totalAge/totalPeople;
    }

    private static Integer getAverageFunctionalProgramming(List<PersonDTO> personList){

       Double average  = personList.stream()
                .mapToInt(PersonDTO::getAge)
                .filter(age -> age >= 18)
                .average().getAsDouble();

        return average.intValue();
    }

}

