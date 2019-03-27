package org.elu.learning.concurrency;

import org.elu.learning.concurrency.counting.Counting;
import org.elu.learning.concurrency.counting.CountingAtomic;
import org.elu.learning.concurrency.counting.CountingSynchronized;
import org.elu.learning.concurrency.downloader.HttpDownloader;
import org.elu.learning.concurrency.echo.EchoServer;
import org.elu.learning.concurrency.interrupt.Interruptible;
import org.elu.learning.concurrency.interrupt.Uninterruptible;
import org.elu.learning.concurrency.linkedList.MyLinkedList;
import org.elu.learning.concurrency.philosophers.DiningPhilosophers;
import org.elu.learning.concurrency.puzzle.Puzzle;

public class App {
    public static void main(String[] args) throws Exception {
        String name = args[0];

        if ("es".equalsIgnoreCase(name)) {
            EchoServer.echo();
        } else if ("ll".equalsIgnoreCase(name)) {
            MyLinkedList.list();
        } else if ("uin".equalsIgnoreCase(name)) {
            Uninterruptible.doit();
        } else if ("in".equalsIgnoreCase(name)) {
            Interruptible.doit();
        } else if ("dw".equalsIgnoreCase(name)) {
            HttpDownloader.download();
        } else if ("dwf".equalsIgnoreCase(name)) {
            HttpDownloader.downloadFixed();
        } else if ("dp".equalsIgnoreCase(name)) {
            DiningPhilosophers.dine();
        } else if ("dpf".equalsIgnoreCase(name)) {
            DiningPhilosophers.dineFixed();
        } else if ("dpt".equalsIgnoreCase(name)) {
            DiningPhilosophers.dineTimeout();
        } else if ("dpc".equalsIgnoreCase(name)) {
            DiningPhilosophers.dineCondition();
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
