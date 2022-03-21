package com.jvetere.worldlogic.classes.kingdoms;


import com.jvetere.worldlogic.main.GLOBAL;
import com.jvetere.worldlogic.types.Kingdom;
import com.jvetere.worldlogic.types.Update;

import java.util.SplittableRandom;
import java.util.stream.IntStream;

public abstract class Node {
    public Kingdom kingdom;
    public int      age,
            x,
            y;
    public Node     north,
            south,
            east,
            west;
    public Node(Kingdom _kingdom, int _x, int _y){
        kingdom = _kingdom;
        x       = _x;
        y       = _y;

        age     = 0;
    }


    public void setNeighbors(Node[][] grid) {
        north = y - 1 > 0                   ? grid[x][y-1] : null;
        south = y + 1 < GLOBAL.WORLD_COLS   ? grid[x][y+1] : null;
        east  = x + 1 < GLOBAL.WORLD_ROWS   ? grid[x+1][y] : null;
        west  = x - 1 > 0                   ? grid[x-1][y] : null;
    }
    public abstract void update(Update action);

    public abstract void update(Update action, Node node);

    //public abstract Rectangle asFX();

    @Override
    public abstract boolean equals(Object o);

    @Override
    public abstract String toString();

    public void ageUp(){
        age++;
    }
    public int rand(int max, int n){
        SplittableRandom splittableRandom = new SplittableRandom();
        IntStream random = splittableRandom.ints(n, 0, max);
        return random.min().getAsInt();
    }
}
