package com.lofongi.app.events.types;

import com.lofongi.app.events.Event;

/**
 * Created by Lofongi on 07.06.2017.
 */
public class MouseButtonEvent extends Event {

    private int keyCode, x, y;

    //where is pressed which button, coordinates
    public MouseButtonEvent(Type type, int keyCode, int x, int y){
        super(type);
        this.keyCode = keyCode;
        this.x = x;
        this.y = y;


    }

    public int getKeyCode() {
        return keyCode;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
