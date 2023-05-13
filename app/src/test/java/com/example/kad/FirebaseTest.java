//package com.example.kad;
//
//import com.google.firebase.firestore.FirebaseFirestore;
//
//import org.junit.Before;
//
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//
//public class FirebaseTest {
//
//    @Mock
//    private FirebaseFirestore db;
//
//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }

//    @Test
//    public void testAddBooking_Logs() {
//        // Create an instance of the class under test
//        Firebase fb = new Firebase();
//
//        // Create test data
//        int roomNumber = 123;
//        boolean snacks = true;
//        int studentNumber = 456;
//        Date start = new Date();
//        Date end = new Date();
//
//        // Mock the Log class
//        ArgumentCaptor<String> logMessageCaptor = ArgumentCaptor.forClass(String.class);
//        Mockito.doNothing().when(Log.class);
//        Log.d(Mockito.anyString(), logMessageCaptor.capture());
//        Mockito.doNothing().when(Log.class);
//        Log.w(Mockito.anyString(), Mockito.anyString(), Mockito.any(Exception.class));
//
//        // Call the addBooking method
//        fb.addBooking(roomNumber, snacks, studentNumber, start, end);
//
//        // Verify the log messages
//        String successLogMessage = logMessageCaptor.getValue();
//        assert successLogMessage != null;
//        assert successLogMessage.contains("DocumentSnapshot successfully written!");
//
//        // Additional assertions can be made if needed
//        // For example, you can verify the failure log message by mocking the OnFailureListener and triggering the failure callback.
//    }

//    @Test
//    public void testCheckFirestore() {
//        // Create an instance of the class under test
//        Context context = InstrumentationRegistry.getTargetContext();
//        FirebaseApp.initializeApp(context);
//        Firebase fb = new Firebase();
//
//        // Call the checkFirestore method
//        fb.checkFirestore("Karl Gilmartin", 22349111, "22349111@studentmail.ul.ie");
//
//        // No assertion is needed for void methods like checkFirestore
//        // The test will pass if no exceptions are thrown and the code executes without errors.
//    }
// }
