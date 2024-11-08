package ua.ithillel.javapro;

import java.util.concurrent.locks.ReentrantLock;

public class DataHandler {

    private final ReentrantLock lock = new ReentrantLock(true);

    public int modify(int num) {
        lock.lock();
        try {
            num = num * 3;
            return num;
        } finally {
            lock.unlock();
        }
    }
}
