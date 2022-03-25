package com.vetere.worldgui.wrappers;

import com.jvetere.worldlogic.main.GLOBAL;
import com.vetere.graphing.Function;
import com.vetere.graphing.Graph;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class GraphGrid extends GridPane {
    Graph graph;

    public GraphGrid(ArrayList<Function> funcs) {
        graph = new Graph(funcs, GLOBAL.WORLD_ROWS);
    }
    void updateVisual() {
        getChildren().clear();
        for(int i = 0; i < GLOBAL.WORLD_ROWS; i++){
            for( int j = 0; j <GLOBAL.WORLD_COLS; j++){
                // create node
                Rectangle rect = new Rectangle(GLOBAL.PIXEL, GLOBAL.PIXEL);
                if(graph.grid[i][j] != 0)
                    rect.setFill(Color.BLACK);
                else {
                    rect.setStroke(Color.BLACK);
                    rect.setStrokeWidth(.1);
                    rect.setFill(Color.WHITE);
                }
                // add node to group
                add(rect ,i , j);

            }
        }
    }
    public void update(){
        updateVisual();
    }
}
