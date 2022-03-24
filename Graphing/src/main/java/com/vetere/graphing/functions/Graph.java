package com.vetere.graphing.functions;

import java.util.ArrayList;

import static java.lang.Math.abs;

public class Graph extends ArrayList<Integer> {
    int ROW_BOUND, COL_BOUND;
    boolean[][] graph, negGraph;
    public Function func;
    public Graph(String _exp, int _ROW_BOUND, int _COL_BOUND) {
        ROW_BOUND = _ROW_BOUND;
        COL_BOUND = _COL_BOUND;
        graph = new boolean[ROW_BOUND][COL_BOUND];
        negGraph = new boolean[ROW_BOUND][COL_BOUND];
        func = new Function(_exp);
        Calculate(COL_BOUND);
        mirror();
    }


    void Calculate(int x) {
        for(int run = 0; run < x; run++) {
            int val = 0;
            for (int index = 0; index < func.constants.size(); index++) {
                if (index < func.exponents.size())
                    val += Math.pow(func.constants.get(index) * run, func.exponents.get(index));
                else
                    val += func.constants.get(index);
            }
            if (val < COL_BOUND && val >= 0)
                graph[run][val] = true;
            else if (abs(val) < COL_BOUND)
                negGraph[run][abs(val)] = true;
            add(run, val);
        }
    }
    public void mirror() {
        int newIndexX = graph.length-1;

        boolean[][] mirrorGraph = new boolean[ROW_BOUND][COL_BOUND];
        for(int x = 0; x < graph.length; x++) {
            for (int y = 0; y < graph[x].length; y++) {
                mirrorGraph[newIndexX][y] = graph[x][y];
            }
            newIndexX--;
        }
        graph = mirrorGraph;
    }
    @Override
    public String toString(){
        StringBuilder visualPos, visualNeg;
        visualPos = new StringBuilder();
        visualNeg = new StringBuilder();
        for(int x = 0; x < graph.length; x++) {
            for (int y = 0; y < graph[x].length; y++) {
                visualPos.append(graph[x][y] ? 1 : 0).append(" ");
                visualNeg.append(negGraph[x][y] ? 1 : 0).append(" ");
            }
            visualPos.append("\n");
            visualNeg.append("\n");
        }
        visualNeg.append(visualPos);
        return visualNeg.toString();
    }
}
