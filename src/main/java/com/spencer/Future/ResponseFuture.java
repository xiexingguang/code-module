package com.spencer.Future;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by spencer on 16/8/4.
 */
public class ResponseFuture {

    public Object result;

    public int requestId;

    public ReentrantLock lock = new ReentrantLock();

    public CountDownLatch countDownLatch = new CountDownLatch(1);

    public CallBack callBack;

    public ResponseFuture(int requestId, CallBack callBack) {
        this.requestId = requestId;
        this.callBack = callBack;
    }

    public Object get(int timeout) {
        try {
           // countDownLatch.await(timeout); //get的时候如何没有set进去,这个时候需要阻塞
            countDownLatch.await(timeout, TimeUnit.SECONDS);//设置超时时间,时间一过,阻塞在这个线程会被唤醒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    //这个方法是会被使用者调用。
    public void setResult(Object o) {
        this.result = o;
        invokeCallBack();//set 结果的时候,调用回掉函数,同时释放锁
        countDownLatch.countDown(); //释放
    }

    /*public Object get(int timeOut) throws InterruptedException {
        lock.tryLock(500, TimeUnit.SECONDS);
        return result;

    }*/

    public void invokeCallBack() {
        callBack.done(result);
    }





}
