package com.spencer.JDK.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by spencer on 16/7/29.
 * 生产者,消费者模式
 * 编写
 * 2个生产者,2个消费者进行协调
 * p1,p2,c1,c2
 * 4个线程进行协调通知执行程序
 */
public class ProductionDemon {

    public static void main(String[] args) {
        List<Goods> goods = new ArrayList<Goods>(); //共享仓库模式
        Thread productor = new Thread(new Productor(goods));
        Thread consumer = new Thread(new Consumer(goods));
        productor.setName("prductor");
        consumer.setName("consumer");
        productor.start();
        consumer.start();
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
                        System.out.println("thread :" + Thread.currentThread().getName() + "===>wait");
                        goods.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                 createProductor();
                  System.out.println("thread :" + Thread.currentThread().getName() + "===>notify");
                 goods.notify();


                }
            }
        }


    //创建商品
    public void createProductor(){
        int random = new Random().nextInt(10000);
        String name = "jasshine" + random;
        System.out.println("productor,商品名称为 +++++++" + name);
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
            if (goods.size() != 1) {
                try {
                    System.out.println("thread :" + Thread.currentThread().getName() + "===>wait");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            takeProductor();
            System.out.println("thread :" + Thread.currentThread().getName() + "====>notify");
            goods.notify();
        }
    }

    public Goods takeProductor() {
        Goods good = goods.get(0); //取商品
        goods.remove(0);
        System.out.println("consumer 消费商品 +++++++++" + good.name + "size :" + goods.size());
        return good;
    }
}