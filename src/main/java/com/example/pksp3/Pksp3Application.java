package com.example.pksp3;

import io.reactivex.rxjava3.core.Observable;

import java.util.Random;

public class Pksp3Application {
    static private Data zipFunc(Object obs, Object obs1){
        return new Data((Temp) obs,(C02) obs1);
    }

	public static void main(String[] args) {
            Sensor sensor = new Sensor();
            Random random = new Random();

            Observable.zip(Observable.create(tempEmitter -> {
                Thread t = new Thread(() -> {
                    int i = 0;
                    while (i < 1000){
                        try {
                            Thread.sleep(1000);
                            Temp temp = new Temp(random.nextInt(15)+15);
                            tempEmitter.onNext(temp);
                            i++;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
                t.start();
            }), Observable.create(tempEmitter -> {
                    Thread t = new Thread(() -> {
                        int i = 0;
                        while (i < 1000){
                            try {
                                Thread.sleep(1000);
                                C02 c02 = new C02(random.nextInt(70)+30);
                                tempEmitter.onNext(c02);
                                i++;
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    t.start();
            }), (obs, obs1) -> zipFunc(obs, obs1)).subscribe(sensor);
    }
}
