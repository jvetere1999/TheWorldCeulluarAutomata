package com.jvetere.worldlogic.world.layers.ground.objects;


import com.jvetere.worldlogic.world.Node;
import com.jvetere.worldlogic.types.EarthType;
import com.jvetere.worldlogic.types.Kingdom;
import com.jvetere.worldlogic.types.Update;

public abstract class Earth extends Node {
    public EarthType type;
    public Earth(EarthType _type, int x, int y) {
        super(Kingdom.EARTH, x, y);
        type = _type;
    }

    @Override
    public abstract void update(Update action);

    @Override
    public abstract void update(Update action, Node node);


    @Override
    public abstract boolean equals(Object o);

    @Override
    public abstract String toString();
}
