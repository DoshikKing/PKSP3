package com.example.pksp3;

import io.reactivex.rxjava3.core.Observable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SecondEx {

    static private Integer square(Integer a){
        return a*a;
    }

    static private String zipFunc(String a, Integer b){
        return a+b;
    }

    public static void main(String[] args){
        Random random = new Random();

        Integer[] array = new Integer[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = random.nextInt(1000);
        }

        String setOfCharacters = "abcdefghxyz-/@";
        String[] array1 = new String[1000];
        for (int i = 0; i < 1000; i++) {
            StringBuilder sb = new StringBuilder();
            int randomInt = random.nextInt(setOfCharacters.length());
            sb.append(setOfCharacters.charAt(randomInt));
            array1[i] = sb.toString();
        }

        Integer[] array_10 = new Integer[10];
        for (int i = 0; i < 10; i++) {
            array_10[i] = random.nextInt(1000);
        }

        System.out.println("1st");
        System.out.println(Arrays.toString(array));
        Observable<Integer> observable = Observable.fromArray(array).map(SecondEx::square);
        List list = new ArrayList();
        observable.subscribe(list::add);
        System.out.println(list);

        System.out.println("2nd");
        System.out.println(Arrays.toString(array));
        Observable<String> observable_string = Observable.fromArray(array1);
        Observable<Integer> observable_int = Observable.fromArray(array);
        Observable<String> observable_string_and_int = Observable.zip(observable_string, observable_int, (a, b) -> zipFunc(a, b));
        List list1 = new ArrayList();
        observable_string_and_int.subscribe(list1::add);
        System.out.println(list1);

        System.out.println("3nd");
        System.out.println(Arrays.toString(array_10));
        Observable<Integer> observable1 = Observable.fromArray(array_10).skip(3);
        List list2 = new ArrayList();
        observable1.subscribe(list2::add);
        System.out.println(list2);
    }
}
