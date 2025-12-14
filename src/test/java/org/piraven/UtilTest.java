package org.piraven;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UtilTest {

    @Test
    @DisplayName("carl santosh -> Carl Santosh")
    void TestToTitleCase1() {
        String name = "carl santosh";
        String expected = "Carl Santosh";
        String actual = Util.toTitleCase(name);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("carl santosh videl -> Carl Santosh Videl")
    void TestToTitleCase2() {
        String name = "carl santosh videl";
        String expected = "Carl Santosh Videl";
        String actual = Util.toTitleCase(name);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("HaREl roShan joHN")
    void TestToTitleCase3() {
        String name = "HaREl roShan joHN";
        String expected = "Harel Roshan John";
        String actual = Util.toTitleCase(name);
        Assertions.assertEquals(expected, actual);
    }
}