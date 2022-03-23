package com.jvetere.worldlogic.world.layers.ground;


import com.jvetere.worldlogic.world.ChangeKnowledge;
import com.jvetere.worldlogic.world.layers.ground.earth.Dirt;
import com.jvetere.worldlogic.world.Node;
import com.jvetere.worldlogic.main.GLOBAL;
import com.jvetere.worldlogic.types.Update;
import com.jvetere.worldlogic.world.layers.ground.plants.Grass;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Ground {

    public Node[][] plane = new Node[GLOBAL.WORLD_ROWS][GLOBAL.WORLD_COLS];

    public Ground() {
        for (int x = 0; x < GLOBAL.WORLD_ROWS; x++) {
            for (int y = 0; y < GLOBAL.WORLD_COLS; y++) {

                plane[x][y] = x == GLOBAL.GRASS && y == GLOBAL.GRASS ? new Grass(x, y) : new Dirt(x, y);

            }
        }
    }
    public void update(){
        for (int x = 0; x < GLOBAL.WORLD_ROWS; x++) {
            for (int y = 0; y < GLOBAL.WORLD_COLS; y++) {
                plane[x][y].setNeighbors(plane);
                ArrayList<ChangeKnowledge> changes = plane[x][y].update(Update.EXPAND);
                if(changes!=null)
                    enactChange(changes);
                plane[x][y].ageUp();
            }
        }
    }

    public void enactChange(ArrayList<ChangeKnowledge> changeArr){
        for(ChangeKnowledge change : changeArr) {
            switch (change.newType) {
                case GRASS -> plane[change.x][change.y] = new Grass(change.x, change.y);
                case DIRT -> plane[change.x][change.y] = new Dirt(change.x, change.y);
            }
        }
    }
    @Override
    public String toString() {
        String str = "";
        for(Node[] n:plane){
            for(Node node:n){
                str +=" ";
                if (node instanceof Grass){
                    str += "G";
                }
                if (node instanceof Dirt){
                    str += "D";
                }
            }
            str += "\n";
        }
        return str;
    }
}
