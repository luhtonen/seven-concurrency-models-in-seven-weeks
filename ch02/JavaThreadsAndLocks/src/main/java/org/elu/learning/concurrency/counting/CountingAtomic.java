package org.elu.learning.concurrency.counting;

import java.util.concurrent.atomic.AtomicInteger;

public class CountingAtomic {
    public static void count() throws InterruptedException {
        final AtomicInteger counter = new AtomicInteger();

        class CountingThread extends Thread {
            public void run() {
                for (int i = 0; i < 10_000; i++) {
                    counter.incrementAndGet();
                }
            }
        }

        CountingThread t1 = new CountingThread();
        CountingThread t2 = new CountingThread();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter.get());
    }
}
