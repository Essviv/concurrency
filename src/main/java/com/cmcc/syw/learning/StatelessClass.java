package com.cmcc.syw.learning;

/**
 * 这个类是无状态的,所以它天生就是线程安全的
 *
 * 无状态的类天生就是线程安全
 *
 * Created by sunyiwei on 16-3-19.
 */
public class StatelessClass {
    public void refactor(int number){
        doSth(number);
    }

    private void doSth(int number){}
}
