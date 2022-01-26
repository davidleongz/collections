package com.example.collections.demos;

import com.example.collections.dto.EmployeeCompanyDTO;
import com.example.collections.dto.PersonCompanyDTO;
import com.example.collections.dto.PersonCompanyDTO;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class MapperListWithDifferentPropertyDemo {

    public static void main(String[] args) {

        PersonCompanyDTO personCompanyA = new PersonCompanyDTO("Pedro", "SA1");
        PersonCompanyDTO personCompanyB = new PersonCompanyDTO("Zaira", "SA2");
        PersonCompanyDTO personCompanyC = new PersonCompanyDTO("Ana", "SA3");
        PersonCompanyDTO personCompanyD = new PersonCompanyDTO("Miguel", "SA4");
        PersonCompanyDTO personCompanyE = new PersonCompanyDTO("Beatriz", "SA5");

        List<PersonCompanyDTO> personCompanyList = Arrays.asList(personCompanyA, personCompanyB, personCompanyC, personCompanyD, personCompanyE);

        List<EmployeeCompanyDTO> employeeCompanyList = personCompanyList.stream().map(p -> new EmployeeCompanyDTO(p.getName(), p.getCompany()))
                .collect(Collectors.toList());

        personCompanyList.forEach(p -> log.info("Company: {}", p.getCompany()));
        employeeCompanyList.forEach(p -> log.info("Enterprise: {}",p.getEnterprise()));
    }
}
