package com.example.collections.dto;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PersonCompanyDTO {

    private String name;
    private String company;

}