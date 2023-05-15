package espresso;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.PositionAssertions.isBelow;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.isNotChecked;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.runner.AndroidJUnit4;

import com.example.kad.MainActivity;
import com.example.kad.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class EspressoTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<MainActivity>(MainActivity.class);
    @Test
    public void everythingDisplayed(){
        Espresso.onView(ViewMatchers.withId(R.id.student_num)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.name)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.email)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.send_btn)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.term_box)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }


    @Test
    public void titleIsDisplayed(){
        onView(withText("KAD Room Booking System")).check(matches(isDisplayed()));
    }
//    @Test
//    public void toastPopUp() {
//        onView(withId(R.id.dates)).perform(click());
//        onView(withText("Button Clicked")).inRoot(ToastMatcher.isToast()).check(matches(isDisplayed()));
//    }





    @Test
    public void loginWithValidCredentials() {

        // Type user name.
        onView(withId(R.id.name))
                .perform(typeText("Karl Gilmartin"), ViewActions.closeSoftKeyboard());
        // Type valid email.
        onView(withId(R.id.email))
                .perform(typeText("22349111@studentmail.ul.ie"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.student_num))
                .perform(typeText("22349111"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.term_box)).check(matches(isNotChecked())).perform(click());


        // Validate login button is enabled.
        onView(withId(R.id.send_btn)).check(matches(isEnabled()));

        // Click the login button.
        onView(withId(R.id.send_btn)).perform(click());

        // Validate welcome string contains user name entered.
//        Intents.init();
//        intended(hasComponent(RoomSelection.class.getName()));
//        Intents.release();

    }
    @Test
    public void welcomeDisplayed() {
        onView(withId(R.id.txt1)).check(matches(isDisplayed()));
        // check to see if it will go to another activity

    }

    @Test
    public void testTermsAndConditionsCheckbox() {
        // Initially, the checkbox should be unchecked
        onView(withId(R.id.term_box)).check(matches(isNotChecked()));

        // Click the checkbox to check it
        onView(withId(R.id.term_box)).perform(click());

        // Validate that the checkbox is checked
        onView(withId(R.id.term_box)).check(matches(isChecked()));

        // Click the checkbox again to uncheck it
        onView(withId(R.id.term_box)).perform(click());

        // Validate that the checkbox is unchecked
        onView(withId(R.id.term_box)).check(matches(isNotChecked()));
    }
    @Test
    public void nameLoc(){
        onView(withId(R.id.name)).check(isBelow(withId(R.id.textView2)));
    }




    @Test
    public void testCheckBox() {
        // Check if the checkbox is initially unchecked
        Espresso.onView(ViewMatchers.withId(R.id.term_box)).check(ViewAssertions.matches(ViewMatchers.isNotChecked()));

        // Perform click action to check the checkbox
        Espresso.onView(ViewMatchers.withId(R.id.term_box)).perform(ViewActions.click());

        // Check if the checkbox is now checked
        Espresso.onView(ViewMatchers.withId(R.id.term_box)).check(ViewAssertions.matches(ViewMatchers.isChecked()));
    }





}
