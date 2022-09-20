package utils;

import java.text.Normalizer;

public class StringUtils {

    public static String unaccent(String src) {
        src = src.replaceAll("œ", "oe");
        return Normalizer
                .normalize(src, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "");
    }

    public static String substringBefore(final String str, final int separator) {
        final int pos = str.indexOf(separator);
        if (pos == -1) {
            return str;
        }
        return str.substring(0, pos);
    }

    public static String substringAfter(final String str, final int separator) {
        final int pos = str.indexOf(separator);
        if (pos == -1) {
            return "";
        }
        return str.substring(pos + 1);
    }

    public static boolean containsAllLetters(final String str, final String letters) {
        String lettersToUpperCase = letters.toUpperCase();
        String strToUpperCase = str.toUpperCase();
        for (int i = 0; i < letters.length(); i++) {
            if (strToUpperCase.indexOf(lettersToUpperCase.charAt(i)) == -1) {
                return false;
            }
        }
        return true;
    }

    public static boolean notContainsAllLetters(final String str, final String letters) {
        String lettersToUpperCase = letters.toUpperCase();
        String strToUpperCase = str.toUpperCase();
        for (int i = 0; i < letters.length(); i++) {
            if (strToUpperCase.indexOf(lettersToUpperCase.charAt(i)) != -1) {
                return false;
            }
        }
        return true;
    }

    public static double countDistinctVowel(final String in) {
        String str = unaccent(in).toUpperCase();
        double res = 0.0;
        if (str.contains("A")) {
            res += 1.0;
        }
        if (str.contains("E")) {
            res += 1.0;
        }
        if (str.contains("I")) {
            res += 1.0;
        }
        if (str.contains("O")) {
            res += 1.0;
        }
        if (str.contains("U")) {
            res += 1.0;
        }
        if (str.contains("Y")) {
            res += 1.0;
        }
        return res;
    }

}
