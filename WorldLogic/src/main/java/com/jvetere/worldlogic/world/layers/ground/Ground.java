package com.jvetere.worldlogic.world.layers.ground;


import com.jvetere.worldlogic.types.objtypes.MasterTypes;
import com.jvetere.worldlogic.world.ChangeKnowledge;
import com.jvetere.worldlogic.world.layers.ground.earth.Dirt;
import com.jvetere.worldlogic.world.Node;
import com.jvetere.worldlogic.main.GLOBAL;
import com.jvetere.worldlogic.types.Update;
import com.jvetere.worldlogic.world.layers.ground.earth.Water;
import com.jvetere.worldlogic.world.layers.ground.plants.Grass;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static com.jvetere.worldlogic.main.GLOBAL.WORLD_COLS;
import static com.jvetere.worldlogic.main.GLOBAL.WORLD_VOLUME;

public class Ground {

    public Node[][] plane = new Node[GLOBAL.WORLD_ROWS][WORLD_COLS];

//    public Ground() {
//        for (int x = 0; x < GLOBAL.WORLD_ROWS; x++) {
//            for (int y = 0; y < WORLD_COLS; y++) {
//
//                plane[x][y] = x == GLOBAL.GRASS && y == GLOBAL.GRASS ? new Grass(x, y) : new Dirt(x, y);
//
//            }
//        }
//    }
    public Ground() {
        int x = 0, y = 0;
        for(MasterTypes type : generateBase()){
            if ( y == WORLD_COLS) {
                y = 0;
                x++;
            }
            plane[x][y] = switch (type) {
                case DIRT -> new Dirt(x, y);
                case GRASS -> new Grass(x, y);
                case WATER -> new Water(x, y);
                default -> throw new IllegalStateException("Unexpected value: " + type);
            };
            y++;
        }
    }
    public void update(ArrayList<Update> updates){
        int index = 0;
        ArrayList<ChangeKnowledge> changes;
        changes = new ArrayList<>();
        for (int x = 0; x < GLOBAL.WORLD_ROWS; x++) {
            for (int y = 0; y < WORLD_COLS; y++) {
                plane[x][y].setNeighbors(plane);
                System.out.println(plane[x][y].type);
                changes.addAll(plane[x][y].update(updates.get(index)));
                if(changes!=null)
                    enactChange(changes);
                plane[x][y].ageUp();
            }
        }
    }

    public void enactChange(ArrayList<ChangeKnowledge> changeArr){
        for(ChangeKnowledge change : changeArr) {
            if (change != null) {
                switch (change.newType) {
                    case GRASS -> plane[change.x][change.y] = new Grass(change.x, change.y);
                    case DIRT -> plane[change.x][change.y] = new Dirt(change.x, change.y);
                    case WATER -> plane[change.x][change.y] = new Water(change.x, change.y);
                }
            }
        }
    }
    //TODO: Fluctuating values based on previous node
    //ie: Water being followed more often by water etc
    public ArrayList<MasterTypes> generateBase(){
        ArrayList<MasterTypes> types;
        types = new ArrayList<>();
        int index = 0;
        int[] bounds = new int[] {10, 90, 100};
        while (index < WORLD_VOLUME) {
            int rand = GLOBAL.rand(bounds[2], 1);
            if (rand < bounds[0]) {
                types.add(MasterTypes.GRASS);
                bounds[1] = 70;
            }
            else if (rand < bounds[1]) {
                types.add(MasterTypes.DIRT);
                bounds[1] = 90;
            }
            else {
                types.add(MasterTypes.WATER);
                bounds[1] = 20;
            }
            index++;
        }
        return types;
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
                if (node instanceof Water){
                    str += "W";
                }
            }
            str += "\n";
        }
        return str;
    }
}
