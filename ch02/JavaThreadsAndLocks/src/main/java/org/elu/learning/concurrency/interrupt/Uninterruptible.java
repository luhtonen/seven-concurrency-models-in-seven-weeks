package org.elu.learning.concurrency.interrupt;

public class Uninterruptible {
    public static void doit() throws InterruptedException {
        final Object o1 = new Object();
        final Object o2 = new Object();

        Thread t1 = new Thread(() -> {
            try {
                synchronized (o1) {
                    Thread.sleep(1000);
                    synchronized (o2) {}
                }
            } catch (InterruptedException ex) {
                System.out.println("t1 interrupted");
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                synchronized (o2) {
                    Thread.sleep(1000);
                    synchronized (o1) {}
                }
            } catch (InterruptedException ex) {
                System.out.println("t2 interrupted");
            }
        });

        t1.start();
        t2.start();
        Thread.sleep(1000);
        t1.interrupt();
        t2.interrupt();
        t1.join();
        t2.join();
    }
}
