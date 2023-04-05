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
    City city;

//    public Employee(String first_name, String last_name, String gender, int age, City city) {
//        this.first_name = first_name;
//        this.last_name = last_name;
//        this.gender = gender;
//        this.age = age;
//        this.city = city;
//    }
}


