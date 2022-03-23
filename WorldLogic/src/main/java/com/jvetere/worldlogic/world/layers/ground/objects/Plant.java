package com.jvetere.worldlogic.world.layers.ground.objects;


import com.jvetere.worldlogic.world.ChangeKnowledge;
import com.jvetere.worldlogic.world.Node;
import com.jvetere.worldlogic.types.Kingdom;
import com.jvetere.worldlogic.types.PlantType;
import com.jvetere.worldlogic.types.Update;

import java.util.ArrayList;

public abstract class Plant extends Node {
    public PlantType type;

    public Plant(PlantType _type,int _x, int _y) {
        super(Kingdom.PLANTS, _x, _y);
        type = _type;
    }


    @Override
    public abstract ArrayList<ChangeKnowledge> update(Update action);


    @Override
    public abstract boolean equals(Object o);

    @Override
    public abstract String toString();
}
