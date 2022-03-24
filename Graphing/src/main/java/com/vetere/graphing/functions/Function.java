package com.vetere.graphing.functions;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Function {
    String exp;
    final Pattern pattern = Pattern.compile("([+-]?(?:(?:\\d+x^\\d+)|(?:\\d+x)|(?:\\d+)|(?:x)))");
    final Pattern subPattern = Pattern.compile("([^0-9])");
    List<Integer> constants;
    List<Integer> exponents;
    public Function (String _exp) {
        constants = new ArrayList<>();
        exponents = new ArrayList<>();
        exp = _exp;
        Matcher matcher = pattern.matcher(exp);
        int x = 0;
        while (matcher.find()) {
            x++;
            System.out.println("Group "+x+": "+matcher.group(1));
            String temp = matcher.group(1);
            boolean neg = temp.contains("-");
            String match = subPattern.matcher(temp).replaceAll("");

            if(temp.length() > 1) {
                constants.add(neg ? -Integer.valueOf(match) : Integer.valueOf(match) );
            }
            else if (temp.equals("x")){
                constants.add(1);
            }
            if (temp.length() == 1 && !temp.equals("x")) {
                exponents.add(neg ? -Integer.valueOf(match) : Integer.valueOf(match) );
            }
            else if (temp.contains("x")&& !temp.equals("x")) {
                exponents.add(1);
            }



        }
    }

}
