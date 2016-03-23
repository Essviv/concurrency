package com.cmcc.syw.learning;

/**
 * Created by sunyiwei on 16-3-22.
 */
public class NoVisibility {
    private static int number;
    private static boolean ready;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                while(!ready){
                    Thread.yield();
                }

                System.out.println(number);
            }
        }).start();

        number = 42;
        ready = true;
    }
}
