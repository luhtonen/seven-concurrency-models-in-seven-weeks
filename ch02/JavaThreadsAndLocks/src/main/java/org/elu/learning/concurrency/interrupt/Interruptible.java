package org.elu.learning.concurrency.interrupt;

import java.util.concurrent.locks.ReentrantLock;

public class Interruptible {
    public static void doit() throws InterruptedException {
        final ReentrantLock l1 = new ReentrantLock();
        final ReentrantLock l2 = new ReentrantLock();

        Thread t1 = new Thread(() -> {
            try {
                l1.lockInterruptibly();
                Thread.sleep(1000);
                l2.lockInterruptibly();
            } catch (InterruptedException e) {
                System.out.println("t1 interrupted");
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                l2.lockInterruptibly();
                Thread.sleep(1000);
                l1.lockInterruptibly();
            } catch (InterruptedException e) {
                System.out.println("t2 interrupted");
            }
        });

        t1.start();
        t2.start();
        Thread.sleep(2000);
        t1.interrupt();
        t2.interrupt();
        t1.join();
        t2.join();
    }
}
