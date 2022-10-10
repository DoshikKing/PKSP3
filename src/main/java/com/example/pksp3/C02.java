package com.example.pksp3;

import rx.Subscriber;

public class C02 extends Subscriber {
    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onNext(Object o) {
        if(Integer.parseInt(o.toString()) > 70){
            System.out.println("ALARM!"+Integer.parseInt(o.toString()));
        }
    }
}
