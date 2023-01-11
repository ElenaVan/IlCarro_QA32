package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class Car {
    String address;
    String make;
    String model;
    String year;
    String fuel;
    String seats;
    String carClass;
    String carNumber;
    String price;
    String about;



}
