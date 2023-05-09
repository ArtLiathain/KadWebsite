package com.example.kad;

import static org.junit.Assert.assertEquals;

import com.google.firebase.firestore.FirebaseFirestore;

import org.junit.Test;

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
//    public void testAudio() {
//        int audioResourceId = R.raw.entry;
//        Context context = mock(Context.class);
//        authlogic.playAudio(context, audioResourceId);
//
//        // Wait for the audio to start playing
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        assertNotNull(mediaPlayer.isPlaying());
//    }


}




