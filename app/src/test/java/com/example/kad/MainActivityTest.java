package com.example.kad;

import static org.junit.Assert.assertEquals;

import com.google.firebase.firestore.FirebaseFirestore;

import org.junit.Test;

public class MainActivityTest  {
    logic1 logic1 = new logic1();
    FirebaseFirestore db;
//    @Before
//    public void setUp() throws Exception {
//        FirebaseOptions options = new FirebaseOptions.Builder()
//                .setApplicationId("1:690565907406:android:b286c0a204b5cf8469a19f")
//                .setApiKey("AIzaSyDqJWTMXGyhSzx6JR9ky7gEosYqCd5yDk8")
//                .setDatabaseUrl("https://kad-testing.firebaseio.com")
//                .build();
//        FirebaseApp.initializeApp(options);
//        db = FirebaseFirestore.getInstance();
//    }
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
    public void student_num_len() {
        assertEquals(true, logic1.student_num_len(22349111));

    }

    @Test
    public void student_num_year() {
        assertEquals(false, logic1.student_num_year(21349111));
    }
Authentication

//    @Test
//    public void testFirebaseConnection() {
//        FirebaseOptions options = new FirebaseOptions.Builder()
//                .setApplicationId("1:690565907406:android:b286c0a204b5cf8469a19f")
//                .setApiKey("AIzaSyDqJWTMXGyhSzx6JR9ky7gEosYqCd5yDk8")
//                .setDatabaseUrl("https://kad-testing.firebaseio.com")
//                .build();
//        FirebaseOptions builder = new FirebaseOptions.Builder().setApplicationId("1:690565907406:android:b286c0a204b5cf8469a19f").setApiKey("AIzaSyDqJWTMXGyhSzx6JR9ky7gEosYqCd5yDk8").setDatabaseUrl("https://kad-testing.firebaseio.com").build();
//
//        FirebaseApp.initializeApp(this, options);
//
//        // Check if the default Firebase app has been initialized
//        assertNotNull(FirebaseApp.getInstance());
//
////        // Check if the Firebase app has a valid name
////        assertEquals(FirebaseApp.getInstance().getName(), "[DEFAULT]");
////
////        // Check if the Firebase app has a valid options object
//        assertEquals(FirebaseApp.getInstance().getOptions(), options);
////
////        // Check if the Firebase app is connected to the database
////        assertTrue(FirebaseApp.getInstance().isDefaultApp());
//
//        // Add more tests if needed
//    }
}

}
main
