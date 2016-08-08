package com.spencer.JDK.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by spencer on 16/8/6.
 */
public class ConditionTest implements  Runnable {

    public static ReentrantLock reentrantLock = new ReentrantLock();
    public static Condition condition = reentrantLock.newCondition();
    @Override
    public void run() {
        reentrantLock.lock();
        System.out.println(Thread.currentThread().getName() + "=== > get the lock");
        try {
            System.out.println("begin wait");
            condition.await();//对了 调用await 会释放lock ,麻蛋 差点忘记了。。。。fuck
            System.out.println("end wait");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println(Thread.currentThread().getName() + "=== >realease lock");
            reentrantLock.unlock();
        }

    }

    public static void main(String[] args) throws InterruptedException {
      /*  ConditionTest conditionTest = new ConditionTest();
        Thread thread = new Thread(conditionTest);
        thread.start();
        Thread.sleep(2000);
        reentrantLock.lock();
        System.out.println(Thread.currentThread().getName()+ " === > get the lock");
        condition.signalAll();
        reentrantLock.unlock();*/

        for(int i=0; i<1;i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

    }

    private static void take() throws InterruptedException {
        reentrantLock.lock();
        System.out.println(Thread.currentThread().getName()+ " === > get the lock");

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("进入子线程执行");
                reentrantLock.lock();
                System.out.println(Thread.currentThread().getName()+ " ++++++ > get the lock");

            }
        }).start();

        System.out.println("begin execute");
        Thread.sleep(5000);
        reentrantLock.unlock();
        System.out.println(Thread.currentThread().getName() + "=== >realease lock");
    }
}
