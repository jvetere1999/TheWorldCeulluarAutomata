package com.vetere.graphing;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Function extends HashMap<Integer, Integer> {
    String exp;
    final Pattern pattern = Pattern.compile("([+-]?[^-+]+)");
    Term head, pointer, butt;
    public Function (String _exp) {
        super();
        exp = _exp;
        Matcher matcher = pattern.matcher(exp);

        int x = 0;
        while (matcher.find()) {
            System.out.println(matcher.group(1));
           if(head == null) {
               head = new Term(matcher.group(1));
               pointer = head;
           }
           else {

               pointer.next = new Term(matcher.group(1));
               pointer.next.previous = pointer;
               pointer = pointer.next;
           }
        }
        butt = pointer;
        pointer = head;

    }

    int Calculate(int x) {
        int outcome = 0;
        pointer = head;
        while (pointer.hasNext()) {
            outcome += pointer.Calculate(x);
            pointer = pointer.next;
        }
        outcome += pointer.Calculate(x);
        pointer = head;
        return outcome;
    }
    @Override
    public Integer get(Object o){
        int x = (int) o;
        if (super.get(x) == null){
            super.put(x, Calculate(x));
            System.out.println(x + " " + super.get(x));
        }
        return super.get(x);
    }
}
