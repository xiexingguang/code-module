package com.spencer.JDK.thread;

/**
 * Created by spencer on 16/7/27.
 */
public class JoinTest_1 {



    public static void main(String[] args) throws  Exception{

        System.out.printf("main thread begin execute");


        Thread t2 = new Thread(new Run2(),"t2");
        Thread t1 = new Thread(new Run1(t2),"t1");


        t1.start();
        t1.join();  //调用join方法,将当前线程阻塞,即调用t1.join所在的线程。该线程就是main线程
         t2.start();

        for(int i = 0;i<100;i++) {
            System.out.println(Thread.currentThread().getName() + " ===>i :" + i);
        }

    }

    static class Run1 implements Runnable {
        private Thread thread;
        public Run1(Thread thread) {
           this.thread = thread;
        }

        public void run() {

            try {
                thread.join(); //阻塞t1,让t2执行,此时thread如果还没start呢? ,则当前线程是不会阻塞的
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(int i = 0;i<100;i++) {
                System.out.println(Thread.currentThread().getName() + "++++>i :" + i);
            }
        }
    }

    static class Run2 implements Runnable {
        public void run() {
            for(int i = 0;i<100;i++) {
                System.out.println(Thread.currentThread().getName() + ".>>>>>>>>>i :" + i);
            }
        }
    }


}
