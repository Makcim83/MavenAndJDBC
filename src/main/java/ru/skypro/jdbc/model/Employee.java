package ru.skypro.jdbc.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter
@ToString

public class Employee {
    int id;
    String first_name;
    String last_name;
    String gender;
    int age;
    int city_id;
}
