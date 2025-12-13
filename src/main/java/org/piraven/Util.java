package org.piraven;

import java.util.Arrays;

public class Util {
    public static String toTitleCase(String str) {
        String[] words = str.split(" ");

        for (String word : words) {
            if (word == null) {
                return null;
            }

            int spaceIdx = word.indexOf(" ");
            String firstLetter = word.substring(0, 1).toUpperCase();
            String restOfName = word.substring(1, spaceIdx).toLowerCase();

            return firstLetter + restOfName + " ";
        }

        return Arrays.toString(words);
    }
}
