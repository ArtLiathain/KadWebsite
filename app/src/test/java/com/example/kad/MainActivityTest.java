package com.example.kad;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainActivityTest {
    @Test
    public void sumTest() {
        logic1 logic1 = new logic1();

        // Test case 1: Single item

        int result1 = logic1.sum(20,2);
        assertEquals(22, result1);


    }
}
