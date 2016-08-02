package com.spencer.JDK.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * Created by spencer on 16/8/1.
 */
public class Semaphoretest1 {

    private static Semaphore semaphore = new Semaphore(10); //10个信号量
    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) {
          for(int i=0; i<20;i++) {
              Thread thread = new Thread(new Runnable() {
                  @Override
                  public void run() {
                      try {
                          System.out.println("Thread come : " + Thread.currentThread().getName());
                          countDownLatch.await();
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                      print();
                  }
              });
              thread.start();
              //
          }
        countDownLatch.countDown();
    }

    public static void print() {
        try {
            semaphore.acquire();
            System.out.println("Thread " + Thread.currentThread().getName() + "++++++get lock");
            System.out.println("Thread name :" + Thread.currentThread().getName() + "  =====>print test");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
           semaphore.release();
            System.out.println("Thread " + Thread.currentThread().getName() +  "--------release lock");
        }
    }

}
