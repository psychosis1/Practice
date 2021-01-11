package org.company.util;

import java.util.regex.Pattern;

public class Check {
    public static int integerPositiveValue(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return -1;
        }
    }


    public static int passwordValue(String value) {
        if (value.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$")){
            return 0;
        }else return -1;

    }
}
