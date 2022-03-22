package com.jvetere.worldlogic.world.layers.ground;


import com.jvetere.worldlogic.world.layers.ground.earth.Dirt;
import com.jvetere.worldlogic.world.Node;
import com.jvetere.worldlogic.main.GLOBAL;
import com.jvetere.worldlogic.types.Update;
import com.jvetere.worldlogic.world.layers.ground.plants.Grass;

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
                plane[x][y].update(Update.EXPAND);
            }
        }
    }
}
