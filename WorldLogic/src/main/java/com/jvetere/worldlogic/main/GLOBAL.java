package com.jvetere.worldlogic.main;
// public static final int

import java.util.SplittableRandom;
import java.util.stream.IntStream;

public class GLOBAL {
    //UI values
    public static final double SCENE_WIDTH = 1024;
    public static final double SCENE_LENGTH = 768;
    public static final int N = 5, M = 5;
    public static final int PIXEL = 5;
    public static final double SECONDS_PER_UPDATE = 500;
    //Logic Values
    public static final int WORLD_ROWS = 100;
    public static final int WORLD_COLS = 100;
    public static final int WORLD_VOLUME = WORLD_COLS * WORLD_ROWS;
    public static final int GRASS = 2;
    //Random ness
    public static final double AGE_MULTIPLAYER = 1;
    //Grass specific
    public static final int GRASS_N_DICE_ROLES = 6;
    public static final int GRASS_DEATH_AGE = 35;
    public static final int DICE = 20; //Maximum number on dice roll
    //Dirt specific
    public static final int DIRT_AGE_EXPANSION = 5;
    //Water specific
    public static final int WATER_AGE_EXPANSION = 1;
    public static final int WATER_DEATH_AGE = 50;
    public static int rand(int max, int n){
        SplittableRandom splittableRandom = new SplittableRandom();
        IntStream random = splittableRandom.ints(n, 0, max);
        return random.min().getAsInt();
    }
}
