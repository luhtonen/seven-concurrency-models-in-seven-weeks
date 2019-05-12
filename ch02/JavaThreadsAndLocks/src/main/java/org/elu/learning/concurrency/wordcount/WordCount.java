package org.elu.learning.concurrency.wordcount;

import java.util.HashMap;

public class WordCount {
    private static final HashMap<String, Integer> counts = new HashMap<>();

    public static void count() {
        long start = System.currentTimeMillis();
        Iterable<Page> pages = new Pages(100000, "enwiki.xml");
        for (Page page: pages) {
            Iterable<String> words = new Words(page.getText());
            for (String word: words) {
                countWord(word);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (end - start) + "ms");
    }

    private static void countWord(String word) {
      counts.merge(word, 1, Integer::sum);
    }
}
