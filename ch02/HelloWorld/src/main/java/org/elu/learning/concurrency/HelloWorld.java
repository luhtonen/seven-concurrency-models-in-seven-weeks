package org.elu.learning.concurrency;

public class HelloWorld {
    public static void main(String[] args) throws InterruptedException {
        /* pre-Java8 style
        Thread myThread = new Thread() {
            public void run() {
                System.out.println("Hello from new thread");
            }
        };
        */
        Thread myThread = new Thread(() -> System.out.println("Hello from new thread"));

        myThread.start();
        Thread.yield();
        System.out.println("Hello from main thread");
        myThread.join();
    }
}
