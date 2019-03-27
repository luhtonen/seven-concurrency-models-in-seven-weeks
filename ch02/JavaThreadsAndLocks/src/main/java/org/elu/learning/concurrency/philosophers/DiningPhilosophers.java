package org.elu.learning.concurrency.philosophers;

import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {
    public static void dine() throws InterruptedException {
        Philosopher[] philosophers = new Philosopher[5];
        Chopstick[] chopsticks = new Chopstick[5];

        for (int i = 0; i < 5; ++i) {
            chopsticks[i] = new Chopstick(i);
        }
        for (int i = 0; i < 5; ++i) {
            philosophers[i] = new Philosopher(chopsticks[i], chopsticks[(i + 1) % 5]);
            philosophers[i].start();
        }
        for (int i = 0; i < 5; ++i) {
            philosophers[i].join();
        }
    }

    public static void dineFixed() throws InterruptedException {
        PhilosopherFixed[] philosophers = new PhilosopherFixed[5];
        Chopstick[] chopsticks = new Chopstick[5];

        for (int i = 0; i < 5; ++i) {
            chopsticks[i] = new Chopstick(i);
        }
        for (int i = 0; i < 5; ++i) {
            philosophers[i] = new PhilosopherFixed(chopsticks[i], chopsticks[(i + 1) % 5]);
            philosophers[i].start();
        }
        for (int i = 0; i < 5; ++i) {
            philosophers[i].join();
        }
    }

    public static void dineTimeout() throws InterruptedException {
        PhilosopherTimeout[] philosophers = new PhilosopherTimeout[5];
        ReentrantLock[] chopsticks = new ReentrantLock[5];

        for (int i = 0; i < 5; ++i) {
            chopsticks[i] = new ReentrantLock();
        }
        for (int i = 0; i < 5; ++i) {
            philosophers[i] = new PhilosopherTimeout(chopsticks[i], chopsticks[(i + 1) % 5]);
            philosophers[i].start();
        }
        for (int i = 0; i < 5; ++i) {
            philosophers[i].join();
        }
    }

    public static void dineCondition() throws InterruptedException {
        PhilosopherCondition[] philosophers = new PhilosopherCondition[5];
        ReentrantLock table = new ReentrantLock();

        for (int i = 0; i < 5; i++) {
            philosophers[i] = new PhilosopherCondition(table);
        }
        for (int i = 0; i < 5; i++) {
            philosophers[i].setLeft(philosophers[(i + 4) % 5]);
            philosophers[i].setRight(philosophers[(i + 1) % 5]);
            philosophers[i].start();
        }
        for (int i = 0; i < 5; i++) {
            philosophers[i].join();
        }
    }
}
