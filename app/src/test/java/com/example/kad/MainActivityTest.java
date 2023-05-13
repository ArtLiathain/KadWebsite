package com.example.kad;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;


public class MainActivityTest  {
    AuthLogic authLogic = new AuthLogic();
    @Test
    public void test_nameLength() {
        assertEquals(true, authLogic.validLength("Karl Gilmartin"));
        assertEquals(false, authLogic.validLength("K")); // Name !> 5
    }

    @Test
    public void name_chars() {
        assertEquals(true, authLogic.stringAlphabet("Eoin O'Brien")); // Regex allows " ' "
        assertEquals(true, authLogic.stringAlphabet("Karl Gilmartín")); // Regex allows names with faddas
    }

    @Test
    public void name_blacklist() {
        assertEquals(false, authLogic.blacklist("Andrew Rivera"));
        assertEquals(true, authLogic.blacklist("Karl Gilmartín"));


    }

    @Test
    public void student_num_len() {
        assertEquals(true, authLogic.studentNumLen(22349111)); // 8 numbers- pass
        assertEquals(true, authLogic.studentNumLen(1));// 1 number-fail

    }

    @Test
    public void student_num_year() {
        assertEquals(false, authLogic.studentNumYear(21349111)); // Starts with 21
        assertEquals(true, authLogic.studentNumYear(22349111)); // Stars with 22
    }



    @Test
    public void testColorAccessibility() {
        int[] color1 = {255, 255, 255}; // White
        int[] color2 = {98, 0, 237}; // Purpule used in app
        int[] color3 = {0, 0, 0}; // Black
        boolean result1 = authLogic.colorAccessibility(color1, color1); // White and White
        boolean result2 = authLogic.colorAccessibility(color1, color2); // White and Purple (Colors used in app)
        boolean result3 = authLogic.colorAccessibility(color1,color3); // White and Black

        // Assert that the result should be true since the contrast ratio is greater than 4.5
        Assert.assertFalse(result1);
        Assert.assertTrue(result2);
        Assert.assertTrue(result3);
    }
}




