package com.spencer.eventDriven;

/**
 * Created by spencer on 16/8/2.
 *
 *
 * 模拟IO 的selctor模型
 */
public class Selector {

    private static ProcessHandler processHandler = new ProcessHandler();

    public void select(String type) {
        if (type.equals("read")) { //当select的时候为读事件,且读到的数据为hello world
            Event event = new ReadEvent("hello world");
            processHandler.process(event, new EventListener() {
                @Override
                public void NotifyListener(Event event) {
                    System.out.println("处理读事件。。。");
                    String result = (String) event.getObject();
                    System.out.println(result);
                }
            });
        }
    }

}
