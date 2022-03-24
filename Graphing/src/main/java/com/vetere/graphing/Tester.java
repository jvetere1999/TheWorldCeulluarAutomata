package com.vetere.graphing;

import com.vetere.graphing.functions.Function;
import com.vetere.graphing.functions.Graph;

public class Tester {

    public static void main(String args[]) {
        String exp = "x+1";
        Function func = new Function(exp);
        Graph graph = new Graph(exp, 50, 50);
        System.out.println(graph);
        graph.mirror();
        System.out.println(graph);
    }
}
