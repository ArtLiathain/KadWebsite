package com.example.kad;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import com.google.firebase.firestore.FirebaseFirestore;

import org.junit.Test;

import java.io.File;

public class MainActivityTest  {
    AuthLogic authlogic = new AuthLogic();
    AuthLogic AuthLogic = new AuthLogic();

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
        assertEquals(true, AuthLogic.validLength("Karl Gilmartin"));
        assertEquals(true, AuthLogic.validLength("k"));
    }

    @Test
    public void name_chars() {
        assertEquals(false, AuthLogic.stringAlphabet("Brid O'Dea"));
        assertEquals(false, AuthLogic.stringAlphabet("Karl Gilmartín"));
        // this is false, the current system doesn't accept "í"
    }

    @Test
    public void name_blacklist() {
        assertEquals(false, AuthLogic.blacklist("Andrew Rivera"));
        assertEquals(true, AuthLogic.blacklist("Karl Gilmartín"));


    }

    @Test
    public void student_num_len() {
        assertEquals(true, AuthLogic.studentNumLen(22349111));

    }

    @Test
    public void student_num_year() {
        assertEquals(false, AuthLogic.studentNumYear(21349111));
    }


//    @Test
//    public void testCheckBox() {
//        // Create a mock CheckBox
//        MainActivity dummyV = mock(MainActivity.class);
//        assertEquals(true,dummyV.checkBox(checkBox));
//    }
    @Test
    public void testAudio() {
        // Specify the path to the audio file
        String audioFilePath = "/Users/karlgilmartin/Documents/CS4442 & CS4443/CS4442/Testing/Project/KadWebsite/app/src/main/res/raw/entry.mp3";

        // Create a file object from the audio file path
        File audioFile = new File(audioFilePath);

        // Check if the audio file exists before testing
        if (audioFile.exists()) {
            // Call the playAudio function with the audio file path
            authlogic.playAudio(audioFilePath);
        } else {
            // Fail the test if the audio file doesn't exist
            fail("Audio file does not exist");
        }
    }


}




