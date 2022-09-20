package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    void countDistinctVowel() {
        assertEquals(StringUtils.countDistinctVowel("Bonjour"), 2.0);
        assertEquals(StringUtils.countDistinctVowel("GUATEMALA"), 3.0);
    }
}
