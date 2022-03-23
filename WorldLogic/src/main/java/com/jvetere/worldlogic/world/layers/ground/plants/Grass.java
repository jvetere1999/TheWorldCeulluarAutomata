package com.jvetere.worldlogic.world.layers.ground.plants;


import com.jvetere.worldlogic.main.GLOBAL;
import com.jvetere.worldlogic.types.Colors;
import com.jvetere.worldlogic.types.objtypes.MasterTypes;
import com.jvetere.worldlogic.world.ChangeKnowledge;
import com.jvetere.worldlogic.world.layers.ground.objects.Plant;
import com.jvetere.worldlogic.world.layers.ground.objects.Earth;
import com.jvetere.worldlogic.world.Node;
import com.jvetere.worldlogic.types.objtypes.PlantType;
import com.jvetere.worldlogic.types.Update;

import java.util.ArrayList;

import static com.jvetere.worldlogic.types.attributes.InanimateAttributes.*;
import static com.jvetere.worldlogic.types.objtypes.MasterTypes.DIRT;

public class Grass extends Plant {
    public Grass(int x, int y) {
        super(MasterTypes.GRASS, x, y);
        label = "Grass";
        attributes.add(HOR_EXPAND);
        attributes.add(FLAMMABLE);
        attributes.add(ALIVE);
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
            case DIE:
                if (attributes.contains(TIME_KILLABLE))change.add(death());
        }
        return change;
    }


    @Override
    public Colors getColor() {
        return Colors.GREEN;
    }

    ChangeKnowledge expand(Node node) {
        if(node instanceof Earth)
            switch (node.type){
                case DIRT:
                    return this.validExpand(node.x, node.y);
            }
        return null;
    }
    ChangeKnowledge validExpand(int _x, int _y) {
        int rand = this.rand((int) Math.abs(GLOBAL.DICE - (this.age * GLOBAL.AGE_MULTIPLAYER)), GLOBAL.GRASS_N_DICE_ROLES);

        if( rand == 0 && age > 2){
            return new ChangeKnowledge(MasterTypes.GRASS, _x, _y);
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
