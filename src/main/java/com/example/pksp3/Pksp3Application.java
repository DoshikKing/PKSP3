package com.example.pksp3;

import rx.Observable;

import java.util.Random;

public class Pksp3Application {
    static private Data zipFunc(Temp obs, C02 obs1){
        return new Data(obs, obs1);
    }

	public static void main(String[] args) throws InterruptedException {
        while (true){
            Sensor sensor = new Sensor();
            Random random = new Random();
            Thread.sleep(1000);
            Temp temp = new Temp(random.nextInt(100));
            C02 c02 = new C02(random.nextInt(100));
            Observable<Temp> observable = Observable.just(temp);
            Observable<C02> observable1 = Observable.just(c02);
            Observable.zip(observable, observable1, (obs, obs1) -> zipFunc(obs, obs1)).subscribe(sensor);
        }
	}

}
