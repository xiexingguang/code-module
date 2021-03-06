package com.spencer.JDK.thread;

/**
 * Created by spencer on 16/7/27.
 *
 * 线程中断测试
 *
 */
public class InterruptTest_1 {
   static Object o = new Object();
   static class Run implements Runnable {
        public void run() {
            synchronized (o) { //用InterruptTest_1.class 就报错,与o 对象锁
                System.out.println("come in , prepared to wait : "+Thread.currentThread().getName());
                try {
                    System.out.println("before wait === >" + Thread.currentThread().isInterrupted());
                    o.wait();
                } catch (InterruptedException e) {
                    System.out.println("exception happend!!"+e);
                    System.out.println("status : " + Thread.currentThread().isInterrupted());
                   // e.printStackTrace();
                   // System.out.println("isinterrupted :" + Thread.interrupted());
                }
            }
        }
    }

    static class Run2 implements Runnable {
        public void run() {
            int i = 0 ;
           // while(i<1000000){
           //     Double d = Math.atan(0.02 * 12);
           //     System.out.println(Thread.currentThread().getName() + "result :" + d);
          //  }
            System.out.println("hello world");
        }
    }



    public static void main (String[] args)throws  Exception {
        Thread thread = new Thread(new Run());
        thread.setName("interrupt test");
        thread.start();

        Thread.sleep(1000);
        Thread t2 = new Thread(new Run2());
        t2.start();
       //t2.join();
        System.out.println("main thread begin " + Thread.currentThread().getName());

        Thread.sleep(1000);
        //中断线程
        thread.interrupt();  //表示只是向线程发出一个中断信号,比如sleep,wait,join线程,这个时候如果遇到中断信号,起
        //System.out.println();
        System.out.println("线程thread 中断状态 :" + thread.isInterrupted());
        //中断线程
        t2.interrupt();
        System.out.println("kkkk===>" + t2.isInterrupted());
        System.out.println("线程thread === 中断状态 :" + thread.isInterrupted());
        System.out.println("线程t2中断状态:"+t2.isInterrupted());
    }

}
