package com.example.kad;

import static org.junit.Assert.assertEquals;

import com.google.firebase.firestore.FirebaseFirestore;

import org.junit.Assert;
import org.junit.Test;

public class MainActivityTest  {
    AuthLogic authLogic = new AuthLogic();

    FirebaseFirestore db;
    //    @Before
//    public void setUp() throws Exception {
//        FirebaseOptions options = new FirebaseOptions.Builder()
//                .setApplicationId()
//                .setApiKey()
//                .setDatabaseUrl("https://kad-testing.firebaseio.com")
//                .build();
//        FirebaseApp.initializeApp(options);
//        db = FirebaseFirestore.getInstance();
//    }
    @Test
    public void test_nameLength() {

        // Test case 1: Single item
        assertEquals(true, authLogic.validLength("Karl Gilmartin"));
        assertEquals(true, authLogic.validLength("k"));
    }

    @Test
    public void name_chars() {
        assertEquals(false, authLogic.stringAlphabet("Brid O'Dea"));
        assertEquals(false, authLogic.stringAlphabet("Karl Gilmartín"));
        // this is false, the current system doesn't accept "í"
    }

    @Test
    public void name_blacklist() {
        assertEquals(false, authLogic.blacklist("Andrew Rivera"));
        assertEquals(true, authLogic.blacklist("Karl Gilmartín"));


    }

    @Test
    public void student_num_len() {
        assertEquals(true, authLogic.studentNumLen(22349111));

    }

    @Test
    public void student_num_year() {
        assertEquals(false, authLogic.studentNumYear(21349111));
    }


//    @Test
//    public void testCheckBox() {
//        // Create a mock CheckBox
//        MainActivity dummyV = mock(MainActivity.class);
//        assertEquals(true,dummyV.checkBox(checkBox));
//    }

    @Test
    public void testColorAccessibility() {
        int[] color1 = {255, 255, 255}; // White color
        int[] color2 = {255, 255, 255}; // Black color
        boolean result = authLogic.colorAccessibility(color1, color2);

        // Assert that the result should be true since the contrast ratio is greater than 4.5
        Assert.assertFalse(result);
    }



}




