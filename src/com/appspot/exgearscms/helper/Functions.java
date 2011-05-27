package com.appspot.exgearscms.helper;

public class Functions {

    public static String truncate(String input, int length) {
        if (input == null) {
            return null;
        }

        if ((input.length() - 1) < length) {
            return input;
        }

        return input.substring(0, length);
    }
}
