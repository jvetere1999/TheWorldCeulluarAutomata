package com.jvetere.worldlogic.classes;


import com.jvetere.worldlogic.classes.earth.Dirt;
import com.jvetere.worldlogic.classes.kingdoms.Node;
import com.jvetere.worldlogic.main.GLOBAL;

public class World {
    public Node[][] world = new Node[GLOBAL.WORLD_ROWS][GLOBAL.WORLD_COLS];

    public World() {
        for (int x = 0; x < GLOBAL.WORLD_ROWS; x++) {
            for (int y = 0; y < GLOBAL.WORLD_COLS; y++) {
                world[x][y] = new Dirt(x, y);

            }
        }
    }
    public void update(){

    }
}
