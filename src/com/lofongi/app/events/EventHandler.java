package com.lofongi.app.events;

import com.lofongi.app.events.Event;

/**
 * Created by Lofongi on 07.06.2017.
 */
public interface EventHandler {

    public boolean handle(Event e);
}
