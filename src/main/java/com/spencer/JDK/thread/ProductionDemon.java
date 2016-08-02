package com.spencer.JDK.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by spencer on 16/7/29.
 * 生产者,消费者模式
 * 编写
 * 1个生产,1个消费者
 * 4个线程进行协调通知执行程序
 *
 * +++++++++++++++++++++++++++++++++++++++
 * 要注意问题:
 * 1:锁要是同一个,即object.wait,object.notify 原因见md
 *
 * 2:生产者,消费者模式要清楚,不然很容易造成思索
 *
 * 生产者:
 * while(true){
 *
 *     1:if(有产品)
 *         obj.wait
 *
 *       create产品
 *       notify   //这个时候,还持有锁,其他线程不能进入其他临界区。
 * }
 *
 * 消费者:
 * while(true){
 *     if(没有产品)
 *        wait
 *     take消费产品
 *     notify
 * }
 *
 *
 *
 *
 *
 *
 *
 */
public class ProductionDemon {

    public static void main(String[] args) {
        List<Goods> goods = new ArrayList<Goods>(); //共享仓库模式
        Thread productor = new Thread(new Productor(goods));
        Thread productor1 = new Thread(new Productor(goods));
        Thread consumer = new Thread(new Consumer(goods));
        Thread consumer1 = new Thread(new Consumer(goods));
        productor.setName("prductor");
        consumer.setName("consumer");
        productor1.setName("productor1");
        consumer1.setName("consumer1");

        productor.start();
        consumer.start();
        productor1.start();
        consumer1.start();
    }

}

class Goods {
    public String name;
    public Goods(String name) {
        this.name = name;
    }
}

/**
 * 生成商品
 */
class Productor implements Runnable {

    private List<Goods> goods;
    public Productor(List<Goods> goods) {
        this.goods = goods;
    }
    @Override
    public void run() {
       // System.out.println();
        synchronized (goods) {
            while(true) {
                if (goods.size() == 1) { //如果有商品就等待
                    try {
                    //    System.out.println("thread :" + Thread.currentThread().getName() + "===>wait");
                        goods.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                 createProductor();
                //  System.out.println("thread :" + Thread.currentThread().getName() + "===>notify");
                 goods.notify();


                }
            }
        }


    //创建商品
    public void createProductor(){
        int random = new Random().nextInt(10000);
        String name = "jasshine" + random;
        System.out.println("productor,生产商品 +++++++" + name);
        goods.add(new Goods(name));
    }

}

//消费商品
class Consumer implements Runnable {

    private List<Goods> goods;

    public Consumer(List<Goods> goods) {
        this.goods = goods;
    }
    @Override
    public void run() {
        synchronized (goods) {

            while(true) {
                if (goods.size() != 1) {
                    try {
                    //    System.out.println("thread :" + Thread.currentThread().getName() + "===>wait");
                        goods.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                takeProductor();
               // System.out.println("thread :" + Thread.currentThread().getName() + "====>notify");
                goods.notify();
            }
        }
    }

    public Goods takeProductor() {
        Goods good = goods.get(0); //取商品
        goods.remove(0);
        System.out.println("consumer 消费商品 ++++++++++++++++++++++" + good.name);
        return good;
    }
}