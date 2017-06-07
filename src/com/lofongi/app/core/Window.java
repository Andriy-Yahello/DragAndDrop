package com.lofongi.app.core;

import com.lofongi.app.events.*;
import com.lofongi.app.events.types.MouseMotionEvent;
import com.lofongi.app.events.types.MousePressedEvent;
import com.lofongi.app.events.types.MouseReleasedEvent;
import com.lofongi.app.layers.Layer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lofongi on 07.06.2017.
 */
//create an empty window Canvas'
    //here will be supscribed all Swing events
public class Window extends Canvas{

    private BufferStrategy bs;
    private  Graphics g;
    private JFrame frame;
    private List<Layer> layers = new ArrayList<Layer>();

    public Window(String  name, int width, int height){
        setPreferredSize(new Dimension(width,height));
        init(name);

        //adding events
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e){
                MousePressedEvent event = new MousePressedEvent(e.getButton(), e.getX(), e.getY());
                // when some event is raised we invoke onEvent and broadcast to all our events
                onEvent(event);
            }

            public void mouseReleased(MouseEvent e){
                MouseReleasedEvent event = new MouseReleasedEvent(e.getButton(), e.getX(), e.getY());
                // when some event is raised we invoke onEvent and broadcast to all our events
                onEvent(event);
            }

        });


        addMouseMotionListener(new MouseMotionListener() {

            public void mouseDragged(MouseEvent e) {
                MouseMotionEvent event = new MouseMotionEvent(e.getX(), e.getY(), false);
                onEvent(event);
            }


            public void mouseMoved(MouseEvent e) {
                MouseMotionEvent event = new MouseMotionEvent(e.getX(), e.getY(), true);
                onEvent(event);
            }
        });

        render();
    }
    //if buffer is not created we create it
    private void render() {
        if(bs == null)
            createBufferStrategy(3);
        bs = getBufferStrategy();
        //taking context. where we can palce some graphics
        g = bs.getDrawGraphics();

        //frame background color
        g.setColor(Color.WHITE);

        g.fillRect(0,0, getWidth(), getHeight());
        onRender(g);
        //clearing system resources from previous graphics
        g.dispose();
        bs.show();

        try {
            Thread.sleep(3);
        }catch(InterruptedException e){

        }
        //() method run
        //render() is what in run method
        //a unanimous function
        //after all events are processed all Swing events we invoke render()
        EventQueue.invokeLater(()-> render());
    }

    private void onRender(Graphics g) {
        for (int i = 0; i <layers.size() ; i++) {
            //all we add we will render
            layers.get(i).onRender(g);
        }
    }
    //thiosis logic
    private void onEvent(com.lofongi.app.events.Event event){
        for (int i = layers.size()-1; i >= 0; i--) {
            //all we add we will render
            layers.get(i).onEvent(event);
        }
    }

    public void addLayer(Layer layer){
        layers.add(layer);
    }

    private void init(String name){
        //create a closable frame
        frame = new JFrame(name);
        //resizing
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.pack();
        //set screen centered
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

    }
}
