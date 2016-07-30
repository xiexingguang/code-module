package com.spencer.JDK.thread;

/**
 * Created by spencer on 16/7/28.
 *
 * 最基本的同步程序,向公共资源res写数据,
 * 另外的线程从里面取数据
 */
public class waitNotifyTest_1 {

    public static Boolean status = false;

    public static void main(String[] args) throws Exception {
        Res res = new Res();
        Thread t1 = new Thread(new Input(res,status));
        Thread t2 = new Thread(new OutPut(res,status));


        t2.start();

        Thread.sleep(1000);
        t1.start();

    }
}


class Res{
    String name;
    String sex;
}

class Input implements  Runnable{

    private Res res;

    private volatile Boolean falg;

    public Input(Res res,Boolean flag) {
        this.res = res;
        this.falg = flag;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            synchronized (res) {
                if (waitNotifyTest_1.status) {  //如果生产了就等待
                    try {
                        System.out.println("input before wait res :" + res + "thread is :[" + Thread.currentThread().getName()+"] flag :" + falg);
                        res.wait(); //等待别人消费
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (i == 0) {
                    res.name = "jasshine";
                    res.sex = "男";
                } else {
                    res.name = "周思彤";
                    res.sex = "女";
                }
                i = (i + 1) % 2;

                waitNotifyTest_1.status = true; //生产了就设置为true

                System.out.println("input before notify res :" + res + "thread is [ :" + Thread.currentThread().getName() + "] flag :" + falg

                );
                res.notify();
            }
        }
    }
}

class OutPut implements Runnable{

    private Res res;

    private volatile Boolean flag;

    public OutPut(Res res,Boolean falg) {
        this.res = res;
        this.flag = falg;
    }

    public void run() {
        while (true) {
            synchronized (res) {
                if (!waitNotifyTest_1.status){  //flag为fale 表示被消费了
                    System.out.println("Out put befor notify res :" + res + "thread is [:" + Thread.currentThread().getName() +"] falg :" +flag);
                    res.notify(); //通知去生产
                }
                System.out.println("name : " + res.name + "===== sex :" + res.sex);
                waitNotifyTest_1.status=false;
                try {

                    System.out.println("out put  before wait :" + res + "thread is [:" + Thread.currentThread().getName() +"] falg :" + flag);
                    res.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}