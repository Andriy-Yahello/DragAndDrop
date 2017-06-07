package com.lofongi.app.events;

/**
 * Created by Lofongi on 07.06.2017.
 */
public class Dispatcher {

    private Event event;

    public Dispatcher(Event event){
        this.event = event;
    }
    //here we handle events
    public void dispatch(Event.Type type, EventHandler handler){
        if(event.handled)
            //if it is already handled we exit
            return;

        //this event equels the type recieved in event we invoke handler
        //we have to return boolean
        if(event.getTyoe()==type)
            event.handled= handler.handle(event);

    }
}
