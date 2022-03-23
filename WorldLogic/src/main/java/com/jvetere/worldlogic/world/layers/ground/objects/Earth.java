package com.jvetere.worldlogic.world.layers.ground.objects;


import com.jvetere.worldlogic.world.ChangeKnowledge;
import com.jvetere.worldlogic.world.Node;
import com.jvetere.worldlogic.types.objtypes.EarthType;
import com.jvetere.worldlogic.types.objtypes.Kingdom;
import com.jvetere.worldlogic.types.Update;

import java.util.ArrayList;

public abstract class Earth extends Node {
    public EarthType type;
    public Earth(EarthType _type, int x, int y) {
        super(Kingdom.EARTH, x, y);
        type = _type;
    }

    @Override
    public abstract ArrayList<ChangeKnowledge> update(Update action);

    @Override
    public abstract boolean equals(Object o);

    @Override
    public abstract String toString();
}
