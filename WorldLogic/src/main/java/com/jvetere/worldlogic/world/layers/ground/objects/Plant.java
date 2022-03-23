package com.jvetere.worldlogic.world.layers.ground.objects;


import com.jvetere.worldlogic.main.GLOBAL;
import com.jvetere.worldlogic.types.objtypes.MasterTypes;
import com.jvetere.worldlogic.world.ChangeKnowledge;
import com.jvetere.worldlogic.world.Node;
import com.jvetere.worldlogic.types.objtypes.Kingdom;
import com.jvetere.worldlogic.types.objtypes.PlantType;
import com.jvetere.worldlogic.types.Update;

import java.util.ArrayList;

import static com.jvetere.worldlogic.main.GLOBAL.GRASS_DEATH_AGE;

public abstract class Plant extends Node {
    public PlantType type;

    public Plant(PlantType _type,int _x, int _y) {
        super(Kingdom.PLANTS, _x, _y);
        type = _type;
    }


    @Override
    public abstract ArrayList<ChangeKnowledge> update(Update action);

    public ChangeKnowledge death() {
        if ( this.rand(Math.abs(GRASS_DEATH_AGE-age), 2) != 0 && age <= GRASS_DEATH_AGE) {
            return null;
        }
        return new ChangeKnowledge(MasterTypes.DIRT, x, y);
    }

    @Override
    public abstract boolean equals(Object o);

    @Override
    public abstract String toString();
}
