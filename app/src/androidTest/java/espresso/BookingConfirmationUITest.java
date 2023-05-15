package espresso;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.PositionAssertions.isCompletelyAbove;
import static androidx.test.espresso.assertion.PositionAssertions.isCompletelyBelow;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.example.kad.activities.BookingConfirmationActivity;
import com.example.kad.R;

import org.junit.Rule;
import org.junit.Test;

public class BookingConfirmationUITest {
    @Rule
    public ActivityScenarioRule<BookingConfirmationActivity> activityRule =
            new ActivityScenarioRule<BookingConfirmationActivity>(BookingConfirmationActivity.class);

    @Test
    public void ConfirmationMessageDisplayed() {
       onView(withId(R.id.textViewMessage)).check(matches(isDisplayed()));
       onView(withId(R.id.textViewMessage)).check(isCompletelyAbove(withId(R.id.returnToRoomSelectionButton)));
    }
    @Test
    public void ReturnButtonDisplayedAndClickable() {
        onView(withId(R.id.returnToRoomSelectionButton)).check((matches(isDisplayed())));
        onView(withId(R.id.returnToRoomSelectionButton)).check(isCompletelyBelow(withId(R.id.textViewMessage)));
    }
}
