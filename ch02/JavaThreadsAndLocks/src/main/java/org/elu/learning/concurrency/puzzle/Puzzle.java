package org.elu.learning.concurrency.puzzle;

public class Puzzle {
    private static boolean answerReady = false;
    private static int answer = 0;
    private static Thread t1 = new Thread(() -> {
        answer = 42;
        answerReady = true;
    });
    private static  Thread t2 = new Thread(() -> {
        if (answerReady) {
            System.out.println("The meaning of life is: " + answer);
        } else {
            System.out.println("I don't know the answer");
        }
    });

    public static void puzzle() throws InterruptedException {
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
