package com.jvetere.worldlogic.classes.kingdoms;


import com.jvetere.worldlogic.types.Kingdom;
import com.jvetere.worldlogic.types.PlantType;
import com.jvetere.worldlogic.types.Update;

public abstract class Plant extends Node {
    protected PlantType type;

    public Plant(PlantType _type,int _x, int _y) {
        super(Kingdom.PLANTS, _x, _y);
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
