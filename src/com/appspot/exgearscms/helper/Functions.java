package com.appspot.exgearscms.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Functions {

    private static final String ESCAPE_REGEX = "(<)(script.*)(>)";

    public static String truncate(String input, int length, String suffix) {
        if (input == null) {
            return null;
        }

        if ((input.length() - 1) < length) {
            return input;
        }

        return input.substring(0, length) + suffix;
    }

    public static String escapeScript(String input) {
        Pattern pattern = Pattern.compile(ESCAPE_REGEX);
        Matcher matcher = pattern.matcher(input);
        return matcher.replaceAll("&lt;$2&gt;");
    }



}
