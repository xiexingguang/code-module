package com.spencer.Future;

/**
 * Created by apple on 16/8/4.
 */
public class Main {
    public static void main(String[] args) {
        final ResponseFuture responseFuture = new ResponseFuture(1, new CallBack() {
            @Override
            public void done(Object result) {
                System.out.println("回调函数被执行了,获取到结果为:" + result);
            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                //执行业务操作比较耗时模拟4s
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //将业务操作返回的结果设置到responseFuture里面
                responseFuture.setResult("helloworld");
            }
        }).start();

        System.out.println(responseFuture.get(1000));

    }

    public ResponseFuture asyncInvok() {
        ResponseFuture responseFuture = new ResponseFuture(1, new CallBack() {
            @Override
            public void done(Object result) {
                //
                System.out.println("回调获取到的结果为:" + result);
            }
        });
        return responseFuture;
    }

}


