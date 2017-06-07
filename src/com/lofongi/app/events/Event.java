package com.lofongi.app.events;

/**
 * Created by Lofongi on 07.06.2017.
 */
public class Event {
    // we gonna store events comming from java events
    //we allow to create Events for all who inherit

    //creating events
    public enum Type{
        MOUSE_MOVED,
        MOUSE_PRESSED,
        MOUUSE_RELEASED,
    }



    private Type type;

    public boolean handled;

    protected Event(Type type){
        // here we crate events
        this.type = type;

    }
    //crating one getter
    public Type getTyoe(){
        return type;
    }
}
