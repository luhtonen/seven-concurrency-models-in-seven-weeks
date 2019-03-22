package org.elu.learning.concurrency.downloader;

import java.net.URL;

public class HttpDownloader {
    public static void download() throws Exception {
        URL from = new URL("http://download.wikimedia.org/enwiki/latest/enwiki-latest-pages-articles.xml.bz2");
        Downloader downloader = new Downloader(from, "download.out");
        downloader.start();
        downloader.addListener(n -> {
            System.out.print("\r" + n);
            System.out.flush();
        });
        downloader.join();
    }
}
