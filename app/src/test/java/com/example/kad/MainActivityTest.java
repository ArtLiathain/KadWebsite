package com.example.kad;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
//import org.robolectric.Robolectric;
//import org.robolectric.RobolectricTestRunner;

public class MainActivityTest {


    @Test
    public void testClick(){
        MainActivity main;
        main = new MainActivity();
//        act = Robolectric.buildActivity(MainActivity.class).create().get();;
        assertEquals(main.testFun(), true);
    }

}