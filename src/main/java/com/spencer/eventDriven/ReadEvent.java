package com.spencer.eventDriven;

/**
 * Created by spencer on 16/8/2.
 *
 * 读事件抽象
 *
 */
public class ReadEvent implements  Event {

    private  String event;

    private  Object object;

    public ReadEvent(Object o) {
        event = "read";
        object = o;
    }

    @Override
    public String getEventType() {
        return event;
    }

    @Override
    public Object getObject() {
        return object;
    }
}
