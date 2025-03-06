package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    void countDistinctVowel() {
        assertEquals(StringUtils.countDistinctVowel("Bonjour"), 2.0);
        assertEquals(StringUtils.countDistinctVowel("GUATEMALA"), 3.0);
    }

    @Test
    void removePlacedLetters() {
        // on remplace les lettres bien placées par '_'
        assertEquals(StringUtils.removePlacedLetters("ECOLE", "E----"), "_COLE");
        assertEquals(StringUtils.removePlacedLetters("ECOLE", "E-OL-"), "_C__E");
    }

    @Test
    void containsAllLetters() {
        assertTrue(StringUtils.containsAllLetters("ECOLE", "COL"));
        assertFalse(StringUtils.containsAllLetters("ECOLE", "COLZ"));
    }

    @Test
    void containsAllLettersWithMatch() {
        assertTrue(StringUtils.containsAllLettersWithMatch("ECOLE", "E", "E-OL-"));
        assertFalse(StringUtils.containsAllLettersWithMatch("ECOLO", "E", "E-OL-"));
        assertThrows(RuntimeException.class,
                () -> StringUtils.containsAllLettersWithMatch("ECOLE", "E", "ECOLOS"));
        assertThrows(RuntimeException.class,
                () -> StringUtils.containsAllLettersWithMatch("ECOLE", "E", "ECOL"));
    }

    @Test
    void notContainsAllLetters() {
        assertTrue(StringUtils.notContainsAllLetters("ECOLE", "ZXY"));
        assertFalse(StringUtils.notContainsAllLetters("ECOLE", "ZXYE"));
    }
}
