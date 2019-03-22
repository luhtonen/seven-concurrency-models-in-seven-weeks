package org.elu.learning.concurrency.downloader;

import java.net.URL;

public class HttpDownloader {
    public static void download() throws Exception {
        URL from = new URL("https://swapi.co/api/planets/1/");
        Downloader downloader = new Downloader(from, "download.out");
        downloader.start();
        downloader.addListener(n -> {
            System.out.print("\r" + n);
            System.out.flush();
        });
        downloader.join();
    }

    public static void downloadFixed() throws Exception {
        URL from = new URL("https://swapi.co/api/planets/2/");
        DownloaderFixed downloader = new DownloaderFixed(from, "download.out");
        downloader.start();
        downloader.addListener(n -> {
            System.out.print("\r" + n);
            System.out.flush();
        });
        downloader.join();
    }
}
