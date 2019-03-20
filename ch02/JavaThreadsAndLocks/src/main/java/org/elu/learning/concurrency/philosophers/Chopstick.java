package org.elu.learning.concurrency.philosophers;

public class Chopstick {
    private int id;

    public Chopstick(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
