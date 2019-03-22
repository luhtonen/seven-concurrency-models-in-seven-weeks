package org.elu.learning.concurrency.philosophers;

import java.util.Random;

public class PhilosopherFixed extends Thread {
    private Chopstick first, second;
    private Random random;
    private int thinkCount;

    public PhilosopherFixed(Chopstick left, Chopstick right) {
        if (left.getId() < right.getId()) {
            first = left;
            second = right;
        } else {
            first = right;
            second = left;
        }
        random = new Random();
    }

    @Override
    public void run() {
        try {
            while (true) {
                thinkCount++;
                if (thinkCount % 10 == 0) {
                    System.out.println("Philosopher " + this + " has thought " + thinkCount + " times");
                }
                Thread.sleep(random.nextInt(1000));
                synchronized (first) {
                    synchronized (second) {
                        Thread.sleep(random.nextInt(1000));
                    }
                }
            }
        } catch (InterruptedException ex) {
        }
    }
}
