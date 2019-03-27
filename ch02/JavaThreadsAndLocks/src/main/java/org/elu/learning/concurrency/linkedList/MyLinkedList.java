package org.elu.learning.concurrency.linkedList;

import java.util.Random;

public class MyLinkedList {
    public static void list() throws InterruptedException {
        final ConcurrentSortedList list = new ConcurrentSortedList();
        final Random random = new Random();

        class TestThread extends Thread {
            public void run() {
                for (int i = 0; i < 10_000; i++) {
                    list.insert(random.nextInt());
                }
            }
        }

        class CountingThread extends Thread {
            public void run() {
                while(!interrupted()) {
                    System.out.println("\r" + list.size());
                    System.out.flush();
                }
            }
        }

        Thread t1 = new TestThread();
        Thread t2 = new TestThread();
        Thread t3 = new CountingThread();

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.interrupt();

        System.out.println("\r" + list.size());

        if (list.size() != 20_000) {
            System.out.println("### Wrong size!");
        }
        if (!list.isSorted()) {
            System.out.println("### Not sorted!");
        }
    }
}
