package com.lofongi.app.events.types;

import com.lofongi.app.events.Event;

/**
 * Created by Lofongi on 07.06.2017.
 */
public class MouseReleasedEvent extends MouseButtonEvent {

    public MouseReleasedEvent( int keyCode, int x, int y){
        super(Event.Type.MOUUSE_RELEASED, keyCode, x, y);

    }
}
