package com.jvetere.worldlogic.classes.earth;

import com.jvetere.worldlogic.classes.kingdoms.Earth;
import com.jvetere.worldlogic.classes.kingdoms.Node;
import com.jvetere.worldlogic.types.Color;
import com.jvetere.worldlogic.types.Update;

;import static com.jvetere.worldlogic.types.Color.BROWN;
import static com.jvetere.worldlogic.types.EarthType.DIRT;

public class Dirt extends Earth {

    public Dirt(int x, int y) {
        super(DIRT, x, y);
    }

    @Override
    public void update(Update action) {

    }

    @Override
    public void update(Update action, Node node) {

    }

    @Override
    public Color getColor() {
        return BROWN;
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
