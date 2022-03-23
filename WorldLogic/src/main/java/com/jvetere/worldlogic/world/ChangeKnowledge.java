package com.jvetere.worldlogic.world;

import com.jvetere.worldlogic.types.objtypes.MasterTypes;

public class ChangeKnowledge {

    public MasterTypes newType;
    public int x, y;

    public ChangeKnowledge(MasterTypes _newType, int _x, int _y) {
        x = _x;
        y = _y;
        newType = _newType;
    }
}
