package com.spencer.JDK.thread;

import java.util.Timer;
import java.util.concurrent.*;

/**
 * Created by apple on 16/8/12.
 */
public class ThreadPoolTest_1 {

    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = new ThreadPoolExecutor(5, 5, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(5));
       // executorService.submit(new )
        for(int i=0; i<20;i++) {
            System.out.println("Thead :" + Thread.currentThread().getName() + "begin await");
            //    countDownLatch.await();
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread name ;" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
      //  countDownLatch.countDown();
      //  Timer
        System.out.println("begin");

    }

}
