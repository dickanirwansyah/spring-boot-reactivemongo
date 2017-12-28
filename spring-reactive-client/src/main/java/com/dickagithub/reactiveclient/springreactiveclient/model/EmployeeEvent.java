package com.dickagithub.reactiveclient.springreactiveclient.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEvent {

    private Employee employee;
    private Date date;
}
