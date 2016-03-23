package com.cmcc.syw.learning;

/**
 * check-and-act中最常见的lazy initialization导致的线程不安全问题
 *
 * Created by sunyiwei on 16-3-19.
 */
public class ThreadUnsafeSingleton {
    private static ThreadUnsafeSingleton pus = null;

    //单例模式的构造函数必须为private
    private ThreadUnsafeSingleton(){

    }

    public static ThreadUnsafeSingleton getInstance(){
        //这里是check-and-set操作,不是线程安全的,如果两个线程如果进入这块代码,就有可能返回不同的对象
        if(pus == null){
            pus = new ThreadUnsafeSingleton();
        }

        return pus;
    }
}

