package ru.tcreator;

import java.util.Random;
import java.util.concurrent.Callable;

public class NewThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int minSleep = 1000;
        int maxSleep = 2000;
        int limit = (10- new Random().nextInt(5));
        int limitSleep = maxSleep - new Random().nextInt(minSleep);
        String name = Thread.currentThread().getName();
        System.out.println(name + " " + limit + " Дискретность: " + limitSleep);
        for (int i = 0; i < limit; i++) {
            Thread.sleep(limitSleep);
            System.out.println("Сообщение от потока " + name + ". Сообщений осталось " + (limit - i));
        }
        System.out.println("Поток " + name + " завершен");
        return limit;
    }
}
