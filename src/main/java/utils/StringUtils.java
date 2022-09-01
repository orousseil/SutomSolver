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

}
