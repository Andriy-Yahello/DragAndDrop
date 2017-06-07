package com.lofongi.app.events;

/**
 * Created by Lofongi on 07.06.2017.
 */
//Those who want to work in our event system will need to implement this interface
public interface EventListener {

    public void onEvent(Event e);
}
