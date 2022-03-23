package com.jvetere.worldlogic.world.layers.ground.earth;

import com.jvetere.worldlogic.world.ChangeKnowledge;
import com.jvetere.worldlogic.world.layers.ground.objects.Earth;
import com.jvetere.worldlogic.world.Node;
import com.jvetere.worldlogic.types.Colors;
import com.jvetere.worldlogic.types.Update;

import java.util.ArrayList;

import static com.jvetere.worldlogic.types.EarthType.DIRT;

public class Dirt extends Earth {

    public Dirt(int x, int y) {
        super(DIRT, x, y);
        label = "Dirt";
    }

    @Override
    public ArrayList<ChangeKnowledge> update(Update action) {
        return null;
    }


    @Override
    public Colors getColor() {
        return Colors.BROWN;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public String toString() {
        return null;
    }
}
