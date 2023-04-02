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

    public Employee(Employee byId) {
    }

    @Override
    public String toString() {
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
