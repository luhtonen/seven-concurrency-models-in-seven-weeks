package org.elu.learning.concurrency.downloader;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.concurrent.CopyOnWriteArrayList;

public class DownloaderBetter extends Thread {
    private InputStream in;
    private OutputStream out;
    private CopyOnWriteArrayList<ProgressListener> listeners;

    public DownloaderBetter(URL url, String outputFilename) throws IOException {
        in = url.openConnection().getInputStream();
        out = new FileOutputStream(outputFilename);
        listeners = new CopyOnWriteArrayList<>();
    }

    public void addListener(ProgressListener listener) {
        listeners.add(listener);
    }

    public void removeListener(ProgressListener listener) {
        listeners.remove(listener);
    }

    private void updateProgress(int n) {
        for (ProgressListener listener : listeners) {
            listener.onProgress(n);
        }
    }

    public void run() {
        int n, total = 0;
        byte[] buffer = new byte[1024];

        try {
            while ((n = in.read(buffer)) != -1) {
                out.write(buffer, 0, n);
                total += n;
                updateProgress(total);
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
