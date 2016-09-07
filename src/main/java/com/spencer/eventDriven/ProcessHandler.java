package com.spencer.eventDriven;

/**
 * Created by apple on 16/8/3.
 */
public class ProcessHandler {

    public void process(Event event,EventListener listener) {
        System.out.println("process deal " + event.getEventType() + "事件");
        listener.NotifyListener(event);
    }
}
