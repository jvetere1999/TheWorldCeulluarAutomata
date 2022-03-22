package com.vetere.worldgui.wrappers;

import com.jvetere.worldlogic.types.PlantType;
import com.jvetere.worldlogic.world.*;
import com.jvetere.worldlogic.world.layers.ground.objects.Earth;
import com.jvetere.worldlogic.world.layers.ground.objects.Plant;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class NodeElement extends StackPane {
    public Node node;
    public NodeElement( double _x, double _y, double _width, double _height, Node _node) {
        node = _node;
        // create rectangle
        Rectangle rectangle = new Rectangle( _width, _height);

        switch (node.getColor()) {
            case GREEN -> rectangle.setFill(Color.GREEN);
            case  BROWN -> rectangle.setFill(Color.SANDYBROWN);
        }
        Label label = new Label(node.label);

        // set position
        setTranslateX( _x);
        setTranslateY( _y);

        getChildren().addAll( rectangle, label);

    }
}
