package ua.ithillel.javapro;

import java.util.concurrent.locks.ReentrantLock;

public class DataHandler {

    private final ReentrantLock lock = new ReentrantLock(true);

    public int modify(int number) {
        if (number == 0) {
            throw new IllegalArgumentException("number is zero");
        }
        try {
            lock.lock();
            number = number * 3;
            return number;
        } finally {
            lock.unlock();
        }
    }

    public int increment(int number) {
        try {
            lock.lock();
            number++;
            return number;
        } finally {
            lock.unlock();
        }
    }
}
