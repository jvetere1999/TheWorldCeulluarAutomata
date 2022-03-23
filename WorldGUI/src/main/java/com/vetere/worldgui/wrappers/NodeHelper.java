package com.vetere.worldgui.wrappers;


import com.jvetere.worldlogic.world.Node;
import javafx.scene.paint.Color;

public class NodeHelper  {
    public static Color getColor(Node node){
        switch (node.getColor()) {
            case BLUE -> {return Color.BLUE;}
            case BROWN -> {return Color.SADDLEBROWN;}
            case GREEN -> {return Color.GREEN;}
        }
        return Color.BLACK;
    }

}
