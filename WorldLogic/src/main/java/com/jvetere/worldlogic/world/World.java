package com.jvetere.worldlogic.world;

import com.jvetere.worldlogic.main.GLOBAL;
import com.jvetere.worldlogic.world.layers.ground.Ground;

public class World {
    Node[][][] world = new Node[GLOBAL.WORLD_ROWS][GLOBAL.WORLD_COLS][3];

    public World(){
        world[0] = new Ground().plane;
    }
}
