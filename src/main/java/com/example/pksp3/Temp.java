package com.example.pksp3;

import rx.Subscriber;

public class Temp extends Subscriber {
    @Override
    public void onCompleted() {
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onNext(Object o) {
        if(Integer.parseInt(o.toString()) > 25){
            System.out.println("ALARM!"+Integer.parseInt(o.toString()));
        }
    }
}
