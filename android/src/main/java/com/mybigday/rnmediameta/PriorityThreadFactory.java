package com.mybigday.rnmediameta;

import android.os.Process;

import java.util.concurrent.ThreadFactory;

/**
 * Created by victor.carvalho on 19/09/2017.
 */

public class PriorityThreadFactory implements ThreadFactory{
    private final int mThreadPriority;

    public PriorityThreadFactory(int threadPriority) {
        mThreadPriority = threadPriority;
    }

    @Override
    public Thread newThread(final Runnable runnable) {
        Runnable wrapperRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Process.setThreadPriority(mThreadPriority);
                } catch (Throwable t) {

                }
                runnable.run();
            }
        };
        return new Thread(wrapperRunnable);
    }
}
