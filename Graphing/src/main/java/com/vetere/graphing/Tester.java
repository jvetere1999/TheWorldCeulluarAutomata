package com.vetere.graphing;

import java.util.ArrayList;
import java.util.List;

public class Tester {

    public static void main(String args[]) {
        String exp = "x^2";
        Function func = new Function(exp);
        List<Function> list = new ArrayList<>();
        list.add(func);
        Graph graph = new Graph(list, 15);
        System.out.println(graph);
        System.out.println(graph);
//        Graph graph = new Graph(exp, 50, 50);
//        System.out.println(graph);
//        graph.mirror();
//        System.out.println(graph);
    }
}
