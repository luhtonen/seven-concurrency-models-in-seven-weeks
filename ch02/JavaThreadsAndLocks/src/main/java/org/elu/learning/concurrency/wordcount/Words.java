package org.elu.learning.concurrency.wordcount;

import java.text.BreakIterator;
import java.util.Iterator;

public class Words implements Iterable<String> {
    private final String text;

    Words(String text) {
        this.text = text;
    }

    private class WordIterator implements Iterator<String> {

        private BreakIterator wordBoundary;
        private int start;
        private int end;

        WordIterator() {
            wordBoundary = BreakIterator.getWordInstance();
            wordBoundary.setText(text);
            start = wordBoundary.first();
            end = wordBoundary.next();
        }

        public boolean hasNext() {
            return end != BreakIterator.DONE;
        }

        public String next() {
            String s = text.substring(start, end);
            start = end;
            end = wordBoundary.next();
            return s;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new WordIterator();
    }
}
