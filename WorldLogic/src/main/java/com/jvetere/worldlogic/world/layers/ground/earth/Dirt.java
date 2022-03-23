package com.jvetere.worldlogic.world.layers.ground.earth;

import com.jvetere.worldlogic.main.GLOBAL;
import com.jvetere.worldlogic.types.attributes.InanimateAttributes;
import com.jvetere.worldlogic.types.objtypes.MasterTypes;
import com.jvetere.worldlogic.world.ChangeKnowledge;
import com.jvetere.worldlogic.world.Node;
import com.jvetere.worldlogic.world.layers.ground.objects.Earth;
import com.jvetere.worldlogic.types.Colors;
import com.jvetere.worldlogic.types.Update;
import com.jvetere.worldlogic.world.layers.ground.objects.Plant;
import com.jvetere.worldlogic.world.layers.ground.plants.Grass;

import java.util.ArrayList;

import static com.jvetere.worldlogic.types.objtypes.EarthType.DIRT;

public class Dirt extends Earth {

    public Dirt(int x, int y) {
        super(MasterTypes.DIRT, x, y);
        label = "Dirt";
        attributes.add(InanimateAttributes.STATIC_STATE);
        attributes.add(InanimateAttributes.DIG_ABLE);
    }

    @Override
    public ArrayList<ChangeKnowledge> update(Update action) {
        ArrayList<ChangeKnowledge> change = new ArrayList<>();
        switch (action) {
            case PASS:
                break;
            case EXPAND:
                ChangeKnowledge temp;
                if(north != null && (north.type != this.type)) {
                    temp = this.expand(north);
                    if(temp != null)
                        change.add(temp);
                }
                if(south!=null && !(south instanceof Dirt)) {
                    temp = this.expand(south);
                    if(temp != null)
                        change.add(temp);
                }
                if(east!=null && !(east instanceof Dirt)){
                    temp = this.expand(east);
                    if(temp != null)
                        change.add(temp);
                }
                if(west!=null&& !(west instanceof Dirt)) {
                    temp = this.expand(west);
                    if(temp != null)
                        change.add(temp);
                }
                break;
            case DIE:
                break;
        }
        return change;
    }
    ChangeKnowledge expand(Node node) {
        switch (node.type) {
            case GRASS -> {
                return this.validExpand(node.x, node.y, node.age);
            }
            case DIRT -> {
                return this.validExpand(node.x, node.y, node.age + 2);
            }
        }

        return null;
    }
    ChangeKnowledge validExpand(int _x, int _y, int _age) {
        int rand = this.rand((int) Math.abs(GLOBAL.DICE - (this.age * GLOBAL.AGE_MULTIPLAYER)), GLOBAL.GRASS_N_DICE_ROLES);

        if( rand == 0 && _age > GLOBAL.DIRT_AGE_EXPANSION){
            return new ChangeKnowledge(MasterTypes.DIRT, _x, _y);
        }
        return null;
    }

    @Override
    public Colors getColor() {
        return Colors.BROWN;
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
