package espresso;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.PositionAssertions.isCompletelyAbove;
import static androidx.test.espresso.assertion.PositionAssertions.isCompletelyBelow;
import static androidx.test.espresso.assertion.PositionAssertions.isCompletelyLeftOf;
import static androidx.test.espresso.assertion.PositionAssertions.isCompletelyRightOf;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.example.kad.R;
import com.example.kad.activities.RoomBookingPageActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class RoomBookingUITest {
    @Rule
    public ActivityScenarioRule<RoomBookingPageActivity> activityRule =
            new ActivityScenarioRule<>(RoomBookingPageActivity.class);
    @Test
    public void KADBookingTitleIsDisplayed() {
        onView(withText("KAD Room Booking")).check(matches(isDisplayed()));
        onView(withText("KAD Room Booking")).check(isCompletelyAbove(withId(R.id.textViewRoomInfo)));
    }
    @Test
    public void InstructionIsDisplayed() {
        onView(withId(R.id.textViewInstruction)).check(matches(isDisplayed()));
        onView(withId(R.id.textViewInstruction)).check(isCompletelyAbove(withId(R.id.datePicker)));
        onView(withId(R.id.textViewInstruction)).check(isCompletelyBelow(withId(R.id.textViewRoomInfo)));
    }
    @Test
    public void DatePickerDisplayed() {
        onView(withId(R.id.datePicker)).check(isCompletelyAbove(withId(R.id.backButtonRoomSelection)));
        onView(withId(R.id.datePicker)).check(isCompletelyAbove(withId(R.id.dropdownTimeSelection)));
        onView(withId(R.id.datePicker)).check(isCompletelyBelow(withId(R.id.textViewInstruction)));
        onView(withId(R.id.datePicker)).perform(click());
    }
    @Test
    public void BackButtonDisplayedAndClickable() {
        onView(withId(R.id.backButtonRoomSelection)).check(isCompletelyLeftOf(withId(R.id.dropdownTimeSelection)));
        onView(withId(R.id.backButtonRoomSelection)).check(isCompletelyBelow(withId(R.id.datePicker)));
        onView(withId(R.id.backButtonRoomSelection)).perform(click());
    }
    @Test
    public void DropdownDisplayed() {
        onView(withId(R.id.dropdownTimeSelection)).check(isCompletelyBelow(withId(R.id.datePicker)));
        onView(withId(R.id.dropdownTimeSelection)).check(isCompletelyRightOf(withId(R.id.backButtonRoomSelection)));
        onView(withId(R.id.dropdownTimeSelection)).check(isCompletelyLeftOf(withId(R.id.placeBookingButton)));
        onView(withId(R.id.dropdownTimeSelection)).perform(click());
    }
    @Test
    public void PlaceBookingButtonDisplayed() {
        onView(withId(R.id.placeBookingButton)).check(isCompletelyBelow(withId(R.id.datePicker)));
        onView(withId(R.id.placeBookingButton)).check(isCompletelyRightOf(withId(R.id.dropdownTimeSelection)));
        onView(withId(R.id.placeBookingButton)).perform(click());
    }
}