package com.codingwithnish;

public interface ValueOfFace {

    public static String toFace(int value) {
        String Svalue = "";
        if (value == 11) {
            Svalue = "JACK";
        } else if (value == 12) {
            Svalue = "QUEEN";

        } else if (value == 13) {
            Svalue = "KING";
        }else if (value == 14) {
            Svalue = "ACE";

        } else {
            Svalue = Integer.toString(value);

        }
        return Svalue;
    }
}