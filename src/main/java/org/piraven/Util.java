package org.piraven;

public class Util {
    public static String toTitleCase(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        String[] words = str.split(" ");
        String result = "";

        for (String word : words) {
            String firstLetter = word.substring(0, 1).toUpperCase();
            String rest = word.substring(1).toLowerCase();
            String titleCaseName = firstLetter + rest;

            result += titleCaseName + " ";
        }

        return result.trim();
    }
}
