package org.elu.learning.concurrency;

import org.elu.learning.concurrency.counting.Counting;
import org.elu.learning.concurrency.counting.CountingSynchronized;

public class App {
    public static void main(String[] args) throws InterruptedException {
        String name = args[0];

        if ("cb".equalsIgnoreCase(name)) {
            CountingSynchronized.count();
        } else {
            Counting.count();
        }
    }
}
