package com.jvetere.worldtestingui.wrappers;

import com.jvetere.worldlogic.classes.kingdoms.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class NodeElement extends StackPane {
    public Node node;
    public NodeElement( String _name, double _x, double _y, double _width, double _height, Node _node) {
        node = _node;
        // create rectangle
        Rectangle rectangle = new Rectangle( _width, _height);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.LIGHTBLUE);

        // create label
        Label label = new Label( _name);

        // set position
        setTranslateX( _x);
        setTranslateY( _y);

        getChildren().addAll( rectangle, label);

    }
}
