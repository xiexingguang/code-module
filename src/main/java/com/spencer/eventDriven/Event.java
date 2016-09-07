package com.spencer.eventDriven;

/**
 * Created by spencer on 16/7/27.
 *
 *  事件标记接口
 */
public interface Event {

    public String getEventType();

    public Object getObject();

}
