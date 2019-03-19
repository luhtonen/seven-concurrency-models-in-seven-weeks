package org.elu.learning.concurrency;

import org.elu.learning.concurrency.counting.Counting;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Counting.count();
    }
}
