package com.cmcc.syw.learning;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 线程不安全的自增类
 * <p/>
 * 线程不安全的原因是因为自增操作不是原子操作
 * <p/>
 * Created by sunyiwei on 16-3-19.
 */
public class UnsafeSequence {
    private int value;

    public void unsafeAdd() {
        value++;
    }

    public synchronized void safeAdd() {
        value++;
    }

    public int getValue() {
        return value;
    }

    public static void main(String[] args) {
        final UnsafeSequence us = new UnsafeSequence();

        final int COUNT = 1000;
        ExecutorService executorService = Executors.newFixedThreadPool(COUNT);
        for (int i = 0; i < COUNT; i++) {
            executorService.submit(new Runnable() {
                public void run() {
                    final int COUNT = 1000;
                    for (int i = 0; i < COUNT; i++) {
                        us.unsafeAdd();
//                        us.safeAdd();
                    }
                }
            });
        }

        executorService.shutdown();
        while (!executorService.isShutdown()) {
            try {
                executorService.awaitTermination(3, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(us.getValue());
    }
}
