package com.vetere.worldgui.wrappers;


import com.jvetere.worldlogic.main.GLOBAL;
import com.jvetere.worldlogic.types.Update;
import com.jvetere.worldlogic.world.layers.ground.Ground;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

import static com.jvetere.worldlogic.main.GLOBAL.WORLD_VOLUME;

public class Grid extends GridPane {

    Ground ground = new Ground();
    public Grid() {
        setPadding(new Insets(10));
        setAlignment(Pos.CENTER);
        updateVisual();
    }
    void updateVisual() {
        getChildren().clear();
        for(int i = 0; i < GLOBAL.WORLD_ROWS; i++){
            for( int j = 0; j <GLOBAL.WORLD_COLS; j++){
                // create node
                Rectangle rect = new Rectangle(GLOBAL.PIXEL, GLOBAL.PIXEL);
                rect.setFill(NodeHelper.getColor(ground.plane[i][j]));
                // add node to group
                add(rect ,i , j);

            }
        }
    }
    public void update() {
        //System.out.println(ground);
        ground.update(generateUpdate());
        updateVisual();
    }
    public ArrayList<Update> generateUpdate(){
        ArrayList<Update> updates;
        updates = new ArrayList<>();
        int index = 0;
        while (index < WORLD_VOLUME) {
            int rand = GLOBAL.rand(100, 1);
            if (rand < 10)
                updates.add(Update.DIE);
            else if (rand < 90)
                updates.add(Update.EXPAND);
            else
                updates.add(Update.PASS);
            index++;
        }
        return updates;
    }
}
