package com.cmcc.syw.learning;

/**
 * 演示了线程安全的单例模式的实现,通过JAVA的锁机制,保证同一时间只能有一个线程对单例对象赋值
 *
 * Created by sunyiwei on 16-3-19.
 */
public class ThreadSafeSingleton {
    private static ThreadSafeSingleton pss = null;

    private ThreadSafeSingleton(){

    }

    public static ThreadSafeSingleton getInstance(){
        //double-check,通过对类加锁,保证同一时间只能有一个线程对pss对象进行赋值操作
        if(pss == null){
            synchronized (ThreadSafeSingleton.class){
                if(pss == null){
                    pss = new ThreadSafeSingleton();
                }
            }
        }

        return pss;
    }
}
