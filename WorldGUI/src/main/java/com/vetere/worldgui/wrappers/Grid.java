package com.vetere.worldgui.wrappers;


import com.jvetere.worldlogic.world.layers.ground.Ground;
import com.vetere.worldgui.GLOBAL;
import javafx.scene.Group;

public class Grid extends Group {
    public Ground ground = new Ground();
    public Grid() {
        for( int i=0; i < GLOBAL.N; i++) {
            for( int j=0; j < GLOBAL.M; j++) {

                // create node
                NodeElement node = new NodeElement( i * GLOBAL.GRID_WIDTH, j * GLOBAL.GRID_LENGTH, GLOBAL.GRID_WIDTH, GLOBAL.GRID_LENGTH, ground.plane[i][j]);

                // add node to group
                getChildren().add( node);

            }
        }
    }
    public void update() {
        System.out.println("Here");
        ground.update();
    }
}
