package com.example.pksp3;

import rx.Observable;
import rx.Subscription;

import java.util.Random;

public class Pksp3Application {

	public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        while(true) {
            Thread.sleep(1000);
            Temp sensor = new Temp();
            Observable observable = Observable.just(random.nextInt(100));
            Subscription subscription = observable.subscribe(sensor);
            subscription.unsubscribe();

            C02 sensor1 = new C02();
            Observable observable1 = Observable.just(random.nextInt(200));
            Subscription subscription1 = observable1.subscribe(sensor1);
            subscription1.unsubscribe();
        }
	}

}
