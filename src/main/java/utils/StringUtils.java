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

    protected static String removePlacedLetters(String str, String match) {
        // on supprime les lettres qui sont déja bien placée
        if (str.length() != match.length()) {
            throw new RuntimeException("Bad call to 'containsAllLettersWithMatch' method.");
        }
        String finalStr = "";
        for (int i = 0; i < match.length(); i++) {
            if (match.charAt(i) == '-') {
                finalStr += str.charAt(i);
            } else {
                // on remplace la lettre bien placée par '_'
                finalStr += '_';
            }
        }
        return finalStr;
    }

    public static boolean containsAllLettersWithMatch(final String str, final String letters, String match) {
        return containsAllLetters(removePlacedLetters(str, match), letters);
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

    public static boolean notContainsAllLetters(final String str, final String letters, String match) {
        return notContainsAllLetters(removePlacedLetters(str, match), letters);
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
