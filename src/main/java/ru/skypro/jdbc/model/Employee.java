package ru.skypro.jdbc.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter

public class Employee {
    int id;
    String first_name;
    String last_name;
    String gender;
    int age;
    int city_id;


    public Employee(String first_name, String last_name, String gender, int age, int city_id) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.age = age;
        this.city_id = city_id;
    }

    @Override
    public String toString() {
//        String stringCity = city_id != null
//                ? ", city_id=" + city_id
//                : "default";

        return "Employee{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", city_id=" + city_id +
                '}';
    }
}
