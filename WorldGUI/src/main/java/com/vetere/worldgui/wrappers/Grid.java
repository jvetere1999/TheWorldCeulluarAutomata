package com.vetere.worldgui.wrappers;


import com.jvetere.worldlogic.world.layers.ground.Ground;
import com.vetere.worldgui.GLOBAL;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

public class Grid extends GridPane {

    Ground ground = new Ground();
    public Grid() {
        setPadding(new Insets(10));
        setAlignment(Pos.CENTER);
        updateVisual();
    }
    void updateVisual() {
        getChildren().clear();
        for( int i = 0; i <GLOBAL.WORLD_ROWS; i++){
            for( int j = 0; j <GLOBAL.WORLD_COLS; j++){
                // create node
                Rectangle rect = new Rectangle(GLOBAL.PIXLE, GLOBAL.PIXLE);
                rect.setFill(NodeHelper.getColor(ground.plane[i][j]));
                // add node to group
                add(rect ,i , j);

            }
        }
    }
    public void update() {
        System.out.println(ground);
        ground.update();
        updateVisual();

    }
}
