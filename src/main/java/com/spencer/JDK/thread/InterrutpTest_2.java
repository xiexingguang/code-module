package com.spencer.JDK.thread;

/**
 * Created by spencer on 16/7/28.
 */
public class InterrutpTest_2 {

    public static void main(String[] args) {
        try {
            MyThread myThread = new MyThread();
            myThread.start();
            Thread.sleep(10000);
            myThread.interrupt();
            System.out.printf("是否停止 ===> : " + myThread.isInterrupted());
        } catch (InterruptedException e) {
            System.out.println("catch");
            e.printStackTrace();
        }
        System.out.println("end");

    }

}


class MyThread extends Thread {

    @Override
    public void run() {
        super.run();
        for(int i = 0; i<500000;i++) {
            System.out.println("i : = " + (i+1));
        }
    }


}
