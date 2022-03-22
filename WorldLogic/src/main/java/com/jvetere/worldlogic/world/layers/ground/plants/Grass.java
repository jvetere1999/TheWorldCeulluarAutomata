package com.jvetere.worldlogic.world.layers.ground.plants;


import com.jvetere.worldlogic.types.Colors;
import com.jvetere.worldlogic.world.layers.ground.earth.Dirt;
import com.jvetere.worldlogic.world.layers.ground.objects.Plant;
import com.jvetere.worldlogic.world.layers.ground.objects.Earth;
import com.jvetere.worldlogic.world.Node;
import com.jvetere.worldlogic.types.PlantType;
import com.jvetere.worldlogic.types.Update;

public class Grass extends Plant {
    public Grass(int x, int y) {
        super(PlantType.GRASS, x, y);
        label = "Grass";
    }
//Todo
    @Override
    public void update(Update action) {
        switch (action) {
            case PASS:
                break;
            case EXPAND:
                this.expand(north);
                this.expand(south);
                this.expand(east);
                this.expand(west);
                break;
        }
    }


    @Override
    public Colors getColor() {
        return Colors.GREEN;
    }

    void expand(Node node) {
        switch (node.kingdom) {
            case EARTH:
               node = this.earthExpand((Earth) node) ? new Grass(x, y) : node;
               break;
        }
    }
    boolean earthExpand(Earth node) {
        switch (node.type) {
            case DIRT:
                return this.dirtExpand((Dirt) node);
        }
        return false;
    }
    boolean dirtExpand(Dirt node) {
        int rand = this.rand(Math.abs(this.age-6), 6);
        if( rand == 0 ){
            return true;
        }
        return false;
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
