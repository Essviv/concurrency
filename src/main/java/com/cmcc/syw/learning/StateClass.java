package com.cmcc.syw.learning;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 这个类是有状态的,如果不能保证对状态变量的访问是安全的,那么这个类就不是线程安全的
 *
 * Created by sunyiwei on 16-3-19.
 */
public class StateClass {
    private int counter = 0;

    public void add(){
        doSth();

        //这个操作不是线程安全的,在多线程情况下存在竞争条件
//        counter++;

        //这个操作是线程安全的,因为它保证在同一时间里,只有一个线程对counter进行操作
        //也可以将counter声明为原子变量,即AtomicInteger,对原子化变量的所有操作都是原子化的
        synchronized (this){
            counter++;
        }
    }

    private void doSth(){}

    public int getCounter() {
        return counter;
    }

    public static void main(String[] args) {
        final StateClass sc = new StateClass();

        final int COUNT = 1000;
        ExecutorService es = Executors.newFixedThreadPool(COUNT);
        for (int i = 0; i < COUNT; i++) {
            es.submit(new Runnable() {
                public void run() {
                    final int COUNT = 1000;
                    for (int j = 0; j < COUNT; j++) {
                        sc.add();
                    }
                }
            });
        }

        es.shutdown();
        while(!es.isShutdown()){
            try {
                es.awaitTermination(1000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(sc.getCounter());
    }
}
