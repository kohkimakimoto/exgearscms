package com.appspot.exgearscms.helper;

import java.text.SimpleDateFormat;
import java.util.Date;
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


    /**
     * Return formated date string
     * @param date
     * @return
     */
    public static String d(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        return df.format(date);
    }

    public static String wiki(String input) {
        StringBuffer ret = new StringBuffer();
        String str = org.slim3.jsp.Functions.h(input);

        Pattern patternA = Pattern.compile("^(https?://.+)");

        String lines[] = str.split("\r\n");

        boolean pretag = false;

        for (int i = 0; i < lines.length; i++) {

            String line = lines[i];
            if (!pretag) {
                line.trim();
            }

            if (line.indexOf("**") == 0 && !pretag) {
                ret.append(htmlh3(line));
                continue;
            }

            if (line.indexOf("*") == 0 && !pretag) {
                ret.append(htmlh2(line));
                continue;
            }

            if (line.indexOf("&lt;pre&gt;") == 0) {
                ret.append(htmlpre(line));
                pretag = true;
                continue;
            }

            if (line.indexOf("&lt;/pre&gt;") == 0) {
                ret.append(htmlpreclose(line));
                pretag = false;
                continue;
            }

            Matcher matcher =  patternA.matcher(line);
            if (matcher.matches() && !pretag) {
                line = htmla(matcher);
            }

            if (line.length() > 0 && !pretag) {
                ret.append(htmlp(line));
                continue;
            }

            if (line.length() == 0 && !pretag) {
                ret.append(htmlbr());
                continue;
            }
            ret.append(line + "\n");
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

    private static String htmlpre(String str) {
        return str.replaceAll("&lt;pre&gt;", "<pre>");
    }

    private static String htmlpreclose(String str) {
        return str.replaceAll("&lt;/pre&gt;", "</pre>");
    }

    private static String htmlbr() {
        return "<br />";
    }

    private static String htmla(Matcher matcher) {
        String str = matcher.group();
        return matcher.replaceAll("<a href=" + str +">" + str + "</a>");
    }

}
