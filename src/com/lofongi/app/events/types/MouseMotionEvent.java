package com.lofongi.app.events.types;

import com.lofongi.app.events.Event;

/**
 * Created by Lofongi on 07.06.2017.
 */
public class MouseMotionEvent extends Event {

    private int x,y;
    private boolean dragged;

    //x and y are coordinates and dragged is for if it was dragged
    public MouseMotionEvent(int x, int y, boolean dragged){
        //here we implicitly show what event
        super(Event.Type.MOUSE_MOVED);
        //initializing fields
        this.x = x;
        this.y = y;
        this.dragged = dragged;


    }

    //crating getters. those who get access to an instance of this class will get all data
    //when an event is committed we get this data with java events and place them in boxes that we are creating

//generating getters and setters
    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }


    public boolean isDragged() {
        return dragged;
    }

}
