package org.elu.learning.concurrency;

import org.elu.learning.concurrency.counting.Counting;
import org.elu.learning.concurrency.counting.CountingAtomic;
import org.elu.learning.concurrency.counting.CountingSynchronized;
import org.elu.learning.concurrency.philosophers.DiningPhilosophers;
import org.elu.learning.concurrency.puzzle.Puzzle;

public class App {
    public static void main(String[] args) throws InterruptedException {
        String name = args[0];

        if ("dp".equalsIgnoreCase(name)) {
            DiningPhilosophers.dine();
        } else if ("cs".equalsIgnoreCase(name)) {
            CountingSynchronized.count();
        } else if ("ca".equalsIgnoreCase(name)) {
            CountingAtomic.count();
        } else if ("pz".equalsIgnoreCase(name)) {
            Puzzle.puzzle();
        } else {
            Counting.count();
        }
    }
}
