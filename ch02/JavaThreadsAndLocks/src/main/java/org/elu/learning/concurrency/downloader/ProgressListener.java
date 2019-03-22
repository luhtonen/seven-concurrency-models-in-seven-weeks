package org.elu.learning.concurrency.downloader;

public interface ProgressListener {
    void onProgress(int current);
}
