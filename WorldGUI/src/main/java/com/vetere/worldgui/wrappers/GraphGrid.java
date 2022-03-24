package com.vetere.worldgui.wrappers;

import com.jvetere.worldlogic.main.GLOBAL;
import com.vetere.graphing.functions.Graph;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GraphGrid extends GridPane {
    Graph graph;

    public GraphGrid(String _exp) {
        graph = new Graph(_exp, GLOBAL.WORLD_ROWS, GLOBAL.WORLD_COLS);
    }
    void updateVisual() {
        getChildren().clear();
        for(int i = 0; i < GLOBAL.WORLD_ROWS; i++){
            for( int j = 0; j <GLOBAL.WORLD_COLS; j++){
                // create node
                Rectangle rect = new Rectangle(GLOBAL.PIXEL, GLOBAL.PIXEL);
                if(graph.get(i) == j)
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
