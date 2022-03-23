package com.jvetere.worldlogic.world.layers.ground.plants;


import com.jvetere.worldlogic.types.Colors;
import com.jvetere.worldlogic.types.MasterTypes;
import com.jvetere.worldlogic.world.ChangeKnowledge;
import com.jvetere.worldlogic.world.layers.ground.earth.Dirt;
import com.jvetere.worldlogic.world.layers.ground.objects.Plant;
import com.jvetere.worldlogic.world.layers.ground.objects.Earth;
import com.jvetere.worldlogic.world.Node;
import com.jvetere.worldlogic.types.PlantType;
import com.jvetere.worldlogic.types.Update;

import java.util.ArrayList;

public class Grass extends Plant {
    public Grass(int x, int y) {
        super(PlantType.GRASS, x, y);
        label = "Grass";
        System.out.println("new grasss");
    }
//Todo
    @Override
    public ArrayList<ChangeKnowledge> update(Update action) {
        ArrayList<ChangeKnowledge> change = new ArrayList<>();
        switch (action) {
            case PASS:
                break;
            case EXPAND:
                ChangeKnowledge temp;
                if(north != null && !(north instanceof Grass)) {
                    temp = this.expand(north);
                    if(temp != null)
                        change.add(temp);
                }
                if(south!=null && !(south instanceof Grass)) {
                    temp = this.expand(south);
                    if(temp != null)
                        change.add(temp);
                }
                if(east!=null && !(east instanceof Grass)){
                    temp = this.expand(east);
                    if(temp != null)
                        change.add(temp);
                }
                if(west!=null&& !(west instanceof Grass)) {
                    temp = this.expand(west);
                    if(temp != null)
                        change.add(temp);
                }
                break;
        }
        return change;
    }


    @Override
    public Colors getColor() {
        return Colors.GREEN;
    }

    ChangeKnowledge expand(Node node) {
        if(node instanceof Earth)
            return this.earthExpand((Earth) node);
        return null;
    }
    ChangeKnowledge earthExpand(Earth node) {
        switch (node.type) {
            case DIRT:
                return this.dirtExpand((Dirt) node);
        }
        return null;
    }
    ChangeKnowledge dirtExpand(Dirt node) {
        System.out.println("There");
        int rand = this.rand(Math.abs(this.age-6), 6);
        System.out.println(rand);
        if( rand == 0 ){
            return new ChangeKnowledge(MasterTypes.GRASS, node.x, node.y);
        }
        return null;
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
