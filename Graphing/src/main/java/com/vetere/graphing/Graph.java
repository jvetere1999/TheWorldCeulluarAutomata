package com.vetere.graphing;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class Graph {
    int BOUND;
    public int[][] grid;
    public List<Function> functionList;
    public Graph(List<Function> _functionList, int _BOUND) {
        BOUND = _BOUND;
        grid = new int[BOUND][BOUND];
        functionList = _functionList;
        int funcNumber = 1;
        for(Function func: functionList){
            for(int x = 0; x < BOUND; x++){
                int y = func.get(x);
                if (y < 0);
                else if (y < BOUND ) {
                    grid[x][y] = funcNumber;
                }
                else break;
            }
            funcNumber++;
        }
    }

    @Override
    public String toString(){
        StringBuilder graph = new StringBuilder();
        int index = 0;
        for(int x = 0; x < BOUND; x++) {
            for(int y = 0; y < BOUND; y++) {
                graph.append(grid[x][y]).append(" ");
            }
            graph.append("\n");
        }
        return graph.toString();
    }
}
