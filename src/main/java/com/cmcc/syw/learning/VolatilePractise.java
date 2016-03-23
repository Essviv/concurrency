package com.cmcc.syw.learning;

import java.util.Random;

/**
 * Created by sunyiwei on 16-3-22.
 */
public class VolatilePractise implements Runnable {
    private volatile boolean bFlag = false;

    public void stop(){
        bFlag = true;
    }

    public void run() {
        Random random = new Random();
        while (!bFlag) {
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("I'm stop!");
    }

    public static void main(String[] args) {
        VolatilePractise vp = new VolatilePractise();
        new Thread(vp).start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        vp.stop();
    }
}
