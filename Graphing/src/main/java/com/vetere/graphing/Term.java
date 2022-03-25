package com.vetere.graphing;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Math.max;
import static java.lang.Math.pow;


public class Term {
    public boolean neg;
    public int constant;
    public String variable;
    //TODO: Create variable class(either enum or object) to track multi variable functions
    public int exponent;
    public Term derivation;
    final Pattern DIVISION = Pattern.compile("((?:[+-])|(?:\\d+)|(?:x))");
    final Pattern SIGN = Pattern.compile("[+-]");
    String exp;

    public Term previous, next;
    public Term (boolean _n, int _constant, String _variable, int _exponent){
        neg = _n;
        constant = _constant;
        variable = _variable;
        exponent = _exponent;
    }
    public Term(String _exp){ //(+/-) e^
        exp = _exp;
        Matcher match = DIVISION.matcher(exp);
        ArrayList<String> members = new ArrayList<>();
        while (match.find()) {
           members.add(match.group(1));
        }
        neg = members.contains("-");
        if(SIGN.matcher(members.get(0)).matches()){
            neg = members.contains("-");
            members.remove(0);
        }
        int size = members.size();
        boolean numeric;
        String mem;
        switch (size){
            case 3:
                constant = Integer.parseInt(members.remove(0));
                variable = members.remove(0);
                exponent = Integer.parseInt(members.remove(0));
                break;
            case 2:
                mem = members.remove(0);
                numeric = isNumeric(mem);
                constant = numeric ? Integer.parseInt(mem) : 1;
                variable = numeric ? members.remove(0) : mem;
                exponent = numeric ? 1 : Integer.parseInt(members.remove(0));
                break;
            case 1:
                mem = members.remove(0);
                numeric = isNumeric(mem);
                constant = numeric ? Integer.parseInt(mem) : 1;
                exponent = numeric ? 0 : 1;
                variable = numeric ? "x" : mem;
                break;
        }
    }
    public int Calculate(int x) {

        int xMultiply = (int) Math.pow(x, exponent);
        int rtr = (int) (constant * xMultiply);

        return neg ? -rtr : rtr;
    }
    //TODO: finish code for derivation
    public Term derive() {
        //derivation = new Term()
        return null;
    }
    public boolean hasNext() {
        return next != null;
    }
    public static boolean isNumeric(String s) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        if (s == null)
            return false;
        return pattern.matcher(s).matches();
    }
    @Override
    public String toString() {
        return constant + " *x ^"+exponent;
    }
}
