package com.jvetere.worldlogic.world;


import com.jvetere.worldlogic.main.GLOBAL;
import com.jvetere.worldlogic.types.Colors;
import com.jvetere.worldlogic.types.attributes.InanimateAttributes;
import com.jvetere.worldlogic.types.objtypes.Kingdom;
import com.jvetere.worldlogic.types.Update;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.SplittableRandom;
import java.util.stream.IntStream;

public abstract class Node {
    public Kingdom kingdom;
    public String label = "undf";
    public int      age,
            x,
            y;
    public Node     north,
            south,
            east,
            west;

    public Set<InanimateAttributes> attributes;
    public Node(Kingdom _kingdom, int _x, int _y){
        attributes  = new HashSet<>();
        kingdom     = _kingdom;
        x           = _x;
        y           = _y;

        age         = 0;
    }



    public void setNeighbors(Node[][] grid) {
        north = y - 1 >= 0                   ? grid[x][y-1] : null;
        south = y + 1 < GLOBAL.WORLD_COLS   ? grid[x][y+1] : null;
        east  = x + 1 < GLOBAL.WORLD_ROWS   ? grid[x+1][y] : null;
        west  = x - 1 >= 0                   ? grid[x-1][y] : null;
    }
    public abstract ArrayList<ChangeKnowledge> update(Update action);


    public abstract Colors getColor();

    @Override
    public abstract boolean equals(Object o);

    @Override
    public abstract String toString();

    public void ageUp(){
        age++;
    }
    public int rand(int max, int n){
        SplittableRandom splittableRandom = new SplittableRandom();
        IntStream random = splittableRandom.ints(n, 0, max+1);
        return random.min().getAsInt();
    }
}
