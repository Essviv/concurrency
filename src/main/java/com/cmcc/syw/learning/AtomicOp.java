package com.cmcc.syw.learning;

import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by sunyiwei on 16-3-23.
 */
public class AtomicOp {
    private String firstName;
    private String secondName;
    private ReentrantReadWriteLock rrw = new ReentrantReadWriteLock();

    public void set(String firstName, String secondName) {
        rrw.writeLock().lock();
        this.firstName = firstName;
        this.secondName = secondName;
        rrw.writeLock().unlock();
    }

    public String getFirstName() {
        rrw.readLock().lock();
        String firstName = this.firstName;
        rrw.readLock().unlock();

        return firstName;
    }

    public String getSecondName() {
        rrw.readLock().lock();
        String secondName = this.secondName;
        rrw.writeLock().lock();
        return secondName;
    }
}
