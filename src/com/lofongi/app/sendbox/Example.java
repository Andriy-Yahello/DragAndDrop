package com.lofongi.app.sendbox;

import com.lofongi.app.events.Dispatcher;
import com.lofongi.app.events.Event;
import com.lofongi.app.events.EventHandler;
import com.lofongi.app.events.types.MouseMotionEvent;
import com.lofongi.app.events.types.MousePressedEvent;
import com.lofongi.app.events.types.MouseReleasedEvent;
import com.lofongi.app.layers.Layer;

import java.awt.*;
import java.util.Random;

/**
 * Created by Lofongi on 07.06.2017.
 */
public class Example extends Layer {

    private String name;
    private Color color;
    private Rectangle box;
    //for drag control
    private boolean dragging = false;

    private int px, py;

    private static final Random random = new Random();

    public Example(String name, Color color){
        this.name = name;
        this.color = color;

        box = new Rectangle(random.nextInt(100) + 50, random.nextInt(100) + 30, 130, 220);

    }



    public void onEvent(Event event){
        //output hash from events
        //System.out.println(event);

        Dispatcher dispatcher = new Dispatcher(event);
        //where appropriate event is set
        dispatcher.dispatch(Event.Type.MOUSE_PRESSED, (Event e) ->onPressed((MousePressedEvent)e)
                //Does the same
               /* new EventHandler() {

            public boolean handle(Event e) {
                return onPressed((MousePressedEvent)e);
            }
        }*/

        );

        dispatcher.dispatch(Event.Type.MOUUSE_RELEASED, (Event e) ->onReleased((MouseReleasedEvent)e));
        dispatcher.dispatch(Event.Type.MOUSE_MOVED, (Event e) ->onMoved((MouseMotionEvent)e));
    }
    //method in layer
    public void onRender(Graphics g){

        g.setColor(color);
        g.fillRect(box.x, box.y, box.width, box.height);

        g.setColor(Color.WHITE);
        g.drawString(name, box.x+15, box.y + 40);
    }

//if we pressed in rectangle then we return dragging true
    private boolean onPressed(MousePressedEvent event){
        if(box.contains(new Point(event.getX(), event.getY())))
            dragging = true;

        //System.out.println("Mouse pressed: " + event.getKeyCode());
        return dragging;
    }

    private boolean onReleased(MouseReleasedEvent event){
        dragging  = false;
        return dragging;
        //System.out.println("Mouse released: " + event.getKeyCode());
        //return false;
        //if return false and in line# 94 return false instead of return draggin we can drag
        // both rectangles when we select them in the middle
    }

    private boolean onMoved(MouseMotionEvent event){
        if(dragging){
            box.x += event.getX() - px;
            box.y += event.getY() - py;
        }
        px = event.getX();
        py = event.getY();
        //System.out.println("Mouse moved: " + event.getX() + "||" + event.getY());
        return dragging;
    }
}
