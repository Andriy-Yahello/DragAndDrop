package com.lofongi.app.events.types;

import com.lofongi.app.events.Event;

/**
 * Created by Lofongi on 07.06.2017.
 */
public class MousePressedEvent extends MouseButtonEvent {

    public MousePressedEvent(int keyCode, int x, int y){
        super(Event.Type.MOUSE_PRESSED, keyCode, x, y);

    }
}
