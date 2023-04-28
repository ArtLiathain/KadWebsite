
package com.example.kad;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainActivityTest {
    logic1 logic1 = new logic1();
    @Test
    public void name_length() {

        // Test case 1: Single item
        assertEquals(true, logic1.name_length("Karl Gilmartin"));
        assertEquals(true, logic1.name_length("k"));
    }
    @Test
    public void name_chars() {
        assertEquals(true, logic1.string_alphabet("Brid O'Dea"));
        assertEquals(false, logic1.string_alphabet("Karl Gilmartín"));
        // this is false, the current system doesn't accept "í"
    }

    @Test
    public void name_blacklist() {
        assertEquals(false, logic1.blacklist("Andrew Rivera"));
        assertEquals(true, logic1.blacklist("Karl Gilmartín"));


    }
    @Test
    public void student_num_len(){
        assertEquals(true, logic1.student_num_len(22349111));

    }
    @Test
    public void student_num_year(){
        assertEquals(false, logic1.student_num_year(21349111));
    }
}