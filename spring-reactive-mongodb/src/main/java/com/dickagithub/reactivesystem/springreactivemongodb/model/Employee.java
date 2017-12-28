package com.dickagithub.reactivesystem.springreactivemongodb.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Document
public class Employee implements Serializable{

    @Id
    private String id;
    private String name;
    private Long salary;
}
