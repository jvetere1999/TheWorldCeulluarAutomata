package com.jvetere.worldlogic.world.layers.ground.earth;

import com.jvetere.worldlogic.main.GLOBAL;
import com.jvetere.worldlogic.types.Colors;
import com.jvetere.worldlogic.types.Update;
import com.jvetere.worldlogic.types.objtypes.EarthType;
import com.jvetere.worldlogic.types.objtypes.MasterTypes;
import com.jvetere.worldlogic.world.ChangeKnowledge;
import com.jvetere.worldlogic.world.Node;
import com.jvetere.worldlogic.world.layers.ground.objects.Earth;
import com.jvetere.worldlogic.world.layers.ground.plants.Grass;

import java.util.ArrayList;

import static com.jvetere.worldlogic.main.GLOBAL.GRASS_DEATH_AGE;
import static com.jvetere.worldlogic.main.GLOBAL.WATER_DEATH_AGE;
import static com.jvetere.worldlogic.types.attributes.InanimateAttributes.HOR_EXPAND;
import static com.jvetere.worldlogic.types.attributes.InanimateAttributes.TIME_KILLABLE;
import static com.jvetere.worldlogic.types.objtypes.EarthType.WATER;

public class Water extends Earth {
    public Water(int x, int y) {

        super(WATER, x, y);
        attributes.add(HOR_EXPAND);
    }

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
                if (attributes.contains(TIME_KILLABLE)) change.add(death());
        }
        return null;
    }
    ChangeKnowledge expand(Node node) {
        return this.validExpand(node.x, node.y, node.age);
    }
    ChangeKnowledge validExpand(int _x, int _y, int _age) {
        int rand = this.rand((int) Math.abs(GLOBAL.DICE - (this.age * GLOBAL.AGE_MULTIPLAYER)), GLOBAL.GRASS_N_DICE_ROLES);

        if( rand == 0 && _age > GLOBAL.WATER_AGE_EXPANSION){
            return new ChangeKnowledge(MasterTypes.WATER, _x, _y);
        }
        return null;
    }
    @Override
    public Colors getColor() {
        return Colors.BLUE;
    }

    public ChangeKnowledge death() {
        if ( this.rand(Math.abs(WATER_DEATH_AGE-age), 2) != 0)  {
            return null;
        }
        return new ChangeKnowledge(MasterTypes.DIRT, x, y);
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
