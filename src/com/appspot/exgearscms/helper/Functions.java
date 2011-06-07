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

    public static String wiki(String input) {
        StringBuffer ret = new StringBuffer();
        String str = org.slim3.jsp.Functions.h(input);

        String lines[] = str.split("\r\n");
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i].trim();

            if (line.indexOf("**") == 0) {
                ret.append(htmlh3(line));
                continue;
            }

            if (line.indexOf("*") == 0) {
                ret.append(htmlh2(line));
                continue;
            }

            if (line.length() > 0) {
                ret.append(htmlp(line));
                continue;
            }

            if (line.length() == 0) {
                ret.append(htmlbr());
                continue;
            }
            ret.append(line);
        }

        return ret.toString();
    }

    private static String htmlh2(String str) {
        return "<h2>" + str.substring(1) + "</h2>\n";
    }

    private static String htmlh3(String str) {
        return "<h3>" + str.substring(2) + "</h3>\n";
    }

    private static String htmlp(String str) {
        return "<p>" + str + "</p>\n";
    }

    private static String htmlbr() {
        return "<br />";
    }

}
