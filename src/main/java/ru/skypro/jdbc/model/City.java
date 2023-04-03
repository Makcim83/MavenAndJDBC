package ru.skypro.jdbc.model;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter


public class City {
    int city_id;
    String city_name;

    @Override
    public String toString() {
        return "City{" +
                "city_id=" + city_id +
                ", city_name='" + city_name + '\'' +
                '}';
    }
}
