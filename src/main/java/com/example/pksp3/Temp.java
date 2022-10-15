package com.example.pksp3;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Temp {

    private int value;

    Temp(int value){
        this.value = value;
    }
}
