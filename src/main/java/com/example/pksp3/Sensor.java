package com.example.pksp3;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class Sensor implements Observer {

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(Object o) {
        Data data = (Data)o;
        Temp temp = new Temp(0);
        C02 c02 = new C02(0);
        if(data.getTemp().getClass().equals(temp.getClass()) || data.getCo2().getClass().equals(c02.getClass())){
            temp = data.getTemp();
            c02 = data.getCo2();
            if (temp.getValue() > 25 && c02.getValue() > 75)
            {
                System.out.println("ALARM! TEMP AND C02 TOO HIGH");
            }
            else if(temp.getValue() > 25)
            {
                System.out.println("ALERT! TEMP HIGH!");
            }
            else if (c02.getValue() > 70){
                System.out.println("ALERT! C02 HIGH!");
            }
        }
    }
}
