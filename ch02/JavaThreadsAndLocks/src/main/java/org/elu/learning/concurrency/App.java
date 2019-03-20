package org.elu.learning.concurrency;

import org.elu.learning.concurrency.counting.Counting;
import org.elu.learning.concurrency.counting.CountingAtomic;
import org.elu.learning.concurrency.counting.CountingSynchronized;

public class App {
    public static void main(String[] args) throws InterruptedException {
        String name = args[0];

        if ("cs".equalsIgnoreCase(name)) {
            CountingSynchronized.count();
        } else if ("ca".equalsIgnoreCase(name)) {
            CountingAtomic.count();
        } else {
            Counting.count();
        }
    }
}
