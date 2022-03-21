package com.jvetere.worldtestingui.wrappers;

import com.jvetere.worldlogic.classes.World;
import com.jvetere.worldtestingui.GLOBAL;
import javafx.scene.Group;

public class Grid extends Group {
    public World world = new World();
    public Grid() {
        for( int i=0; i < GLOBAL.N; i++) {
            for( int j=0; j < GLOBAL.M; j++) {

                // create node
                NodeElement node = new NodeElement( "Item " + i + "/" + j, i * GLOBAL.GRID_WIDTH, j * GLOBAL.GRID_LENGTH, GLOBAL.GRID_WIDTH, GLOBAL.GRID_LENGTH, world.world[i][j]);

                // add node to group
                getChildren().add( node);

            }
        }
    }
}
