package org.elu.learning.concurrency;

import org.elu.learning.concurrency.counting.Counting;
import org.elu.learning.concurrency.counting.CountingAtomic;
import org.elu.learning.concurrency.counting.CountingSynchronized;
import org.elu.learning.concurrency.downloader.HttpDownloader;
import org.elu.learning.concurrency.interrupt.Uninterrutable;
import org.elu.learning.concurrency.philosophers.DiningPhilosophers;
import org.elu.learning.concurrency.puzzle.Puzzle;

public class App {
    public static void main(String[] args) throws Exception {
        String name = args[0];

        if ("uin".equalsIgnoreCase(name)) {
            Uninterrutable.doit();
        } else if ("dw".equalsIgnoreCase(name)) {
            HttpDownloader.download();
        } else if ("dwf".equalsIgnoreCase(name)) {
            HttpDownloader.downloadFixed();
        } else if ("dp".equalsIgnoreCase(name)) {
            DiningPhilosophers.dine();
        } else if ("dpf".equalsIgnoreCase(name)) {
            DiningPhilosophers.dineFixed();
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
