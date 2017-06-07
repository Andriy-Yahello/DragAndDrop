package com.lofongi.app;

import com.lofongi.app.core.Window;
import com.lofongi.app.sendbox.Example;
import javafx.scene.paint.Color;

/**
 * Created by Lofongi on 07.06.2017.
 */
public class Main {
    public static void main(String[] args) {
        Window window = new Window("Screen", 1000, 800);
        window.addLayer(new Example("New Layer", java.awt.Color.BLUE));
        window.addLayer(new Example("New Second", java.awt.Color.gray));
    }

}
