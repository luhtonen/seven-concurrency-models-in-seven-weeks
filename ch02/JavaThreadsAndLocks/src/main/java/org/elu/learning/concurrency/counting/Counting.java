package org.elu.learning.concurrency.counting;

public class Counting {
    public static void count() throws InterruptedException {
        class Counter {
            private int count = 0;
            void increment() {
                ++count;
            }
            private int getCount() {
                return count;
            }
        }
        final Counter counter = new Counter();

        class CountingThread extends Thread {
            public void run() {
                for (int i = 0; i < 10_000; i++) {
                    counter.increment();
                }
            }
        }

        CountingThread t1 = new CountingThread();
        CountingThread t2 = new CountingThread();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter.getCount());
    }
}
