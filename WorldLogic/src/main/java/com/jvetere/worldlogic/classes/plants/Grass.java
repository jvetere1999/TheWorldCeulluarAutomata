package com.jvetere.worldlogic.classes.plants;


import com.jvetere.worldlogic.classes.earth.Dirt;
import com.jvetere.worldlogic.classes.kingdoms.Earth;
import com.jvetere.worldlogic.classes.kingdoms.Node;
import com.jvetere.worldlogic.classes.kingdoms.Plant;
import com.jvetere.worldlogic.types.PlantType;
import com.jvetere.worldlogic.types.Update;

public class Grass extends Plant {
    public Grass(int x, int y) {
        super(PlantType.GRASS, x, y);
    }

    @Override
    public void update(Update action) {
        switch (action) {
            case PASS:
                break;
            case EXPAND:
                System.out.println("No target");
        }
    }

    @Override
    public void update(Update action, Node node) {
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
