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

    public static String wiki(String input) {
        StringBuffer ret = new StringBuffer();
        String str = org.slim3.jsp.Functions.h(input);

        String lines[] = str.split("\r\n");
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];

            if (line.indexOf("**") == 0) {
                ret.append(h3(line));
                continue;
            }

            if (line.indexOf("*") == 0) {
                ret.append(h2(line));
                continue;
            }


            if (i != (lines.length - 1)) {
                ret.append(br(line));
                continue;
            }

            ret.append(line);
        }

        return ret.toString();
    }

    private static String h2(String str) {
        return "<h2>" + str.substring(1) + "</h2>\n";
    }

    private static String h3(String str) {
        return "<h3>" + str.substring(2) + "</h3>\n";
    }

    private static String br(String str) {
        return str + "<br />\n";
    }



}
