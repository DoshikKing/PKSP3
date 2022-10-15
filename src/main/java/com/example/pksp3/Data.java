package com.example.pksp3;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Data {

    private Temp temp;
    private C02 co2;

    Data(Temp temp, C02 co2){
        this.temp = temp;
        this.co2 = co2;
    }
}
