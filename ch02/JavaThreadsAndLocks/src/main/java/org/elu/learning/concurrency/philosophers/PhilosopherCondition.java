package org.elu.learning.concurrency.philosophers;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PhilosopherCondition extends Thread {
    private boolean eating;
    private PhilosopherCondition left;
    private PhilosopherCondition right;
    private ReentrantLock table;
    private Condition condition;
    private Random random;

    public PhilosopherCondition(ReentrantLock table) {
        eating = false;
        this.table = table;
        condition = table.newCondition();
        random = new Random();
    }

    public void setLeft(PhilosopherCondition left) {
        this.left = left;
    }

    public void setRight(PhilosopherCondition right) {
        this.right = right;
    }

    public void run() {
        try {
            while (true) {
                think();
                eat();
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    private void think() throws InterruptedException {
        table.lock();
        try {
            eating = false;
            left.condition.signal();
            right.condition.signal();
            System.out.println("Philosopher " + this + " is thinking...");
        } finally {
            table.unlock();
        }
        Thread.sleep(1000);
    }

    private void eat() throws InterruptedException {
        table.lock();
        try {
            while (left.eating || right.eating) {
                condition.await();
            }
            eating = true;
            System.out.println("Philosopher " + this + " is eating...");
        } finally {
            table.unlock();
        }
        Thread.sleep(1000);
    }
}
