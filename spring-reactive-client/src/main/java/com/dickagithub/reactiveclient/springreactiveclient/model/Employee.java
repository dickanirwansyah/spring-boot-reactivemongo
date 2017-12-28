package com.dickagithub.reactiveclient.springreactiveclient.model;

import lombok.*;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private String id;
    private String name;
    private Long salary;
}
