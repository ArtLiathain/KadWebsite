package espresso;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.PositionAssertions.isCompletelyAbove;
import static androidx.test.espresso.assertion.PositionAssertions.isCompletelyBelow;
import static androidx.test.espresso.assertion.PositionAssertions.isCompletelyLeftOf;
import static androidx.test.espresso.assertion.PositionAssertions.isCompletelyRightOf;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.example.kad.BookingConfirmation;
import com.example.kad.MainActivity;
import com.example.kad.R;

import org.junit.Rule;
import org.junit.Test;

public class BookingConfirmationUITest {
    @Rule
    public ActivityScenarioRule<BookingConfirmation> activityRule =
            new ActivityScenarioRule<BookingConfirmation>(BookingConfirmation.class);

    @Test
    public void ConfirmationMessageDisplayed() {
       onView(withId(R.id.textViewMessage)).check(matches(isDisplayed()));
       onView(withId(R.id.textViewMessage)).check(isCompletelyAbove(withId(R.id.textViewRoomConfirmation)));
       onView(withId(R.id.textViewMessage)).check(isCompletelyAbove(withId(R.id.textViewRoomConfirmationArgument)));
    }

    @Test
    public void RoomConfirmationTextDisplayed() {
        onView(withId(R.id.textViewRoomConfirmation)).check(matches(isDisplayed()));
        onView(withId(R.id.textViewRoomConfirmation)).check(isCompletelyAbove(withId(R.id.textViewDateConfirmation)));
        onView(withId(R.id.textViewRoomConfirmation)).check(isCompletelyBelow(withId(R.id.textViewMessage)));
        onView(withId(R.id.textViewRoomConfirmation)).check(isCompletelyLeftOf(withId(R.id.textViewRoomConfirmationArgument)));
    }
    @Test
    public void DateConfirmationTextDisplayed() {
        onView(withId(R.id.textViewDateConfirmation)).check(matches(isDisplayed()));
        onView(withId(R.id.textViewDateConfirmation)).check(isCompletelyAbove(withId(R.id.textViewTimeConfirmation)));
        onView(withId(R.id.textViewDateConfirmation)).check(isCompletelyBelow(withId(R.id.textViewRoomConfirmation)));
        onView(withId(R.id.textViewDateConfirmation)).check(isCompletelyLeftOf(withId(R.id.textViewDateConfirmationArgument)));
    }
    @Test
    public void TimeConfirmationTextDisplayed() {
        onView(withId(R.id.textViewTimeConfirmation)).check(matches(isDisplayed()));
        onView(withId(R.id.textViewTimeConfirmation)).check(isCompletelyAbove(withId(R.id.returnToRoomSelectionButton)));
        onView(withId(R.id.textViewTimeConfirmation)).check(isCompletelyBelow(withId(R.id.textViewDateConfirmation)));
        onView(withId(R.id.textViewTimeConfirmation)).check(isCompletelyLeftOf(withId(R.id.textViewTimeConfirmationArgument)));
    }
    @Test
    public void RoomConfirmationArgumentDisplayed() {
        onView(withId(R.id.textViewRoomConfirmationArgument)).check(matches(isDisplayed()));
        onView(withId(R.id.textViewRoomConfirmationArgument)).check(isCompletelyAbove(withId(R.id.textViewDateConfirmationArgument)));
        onView(withId(R.id.textViewRoomConfirmationArgument)).check(isCompletelyBelow(withId(R.id.textViewMessage)));
        onView(withId(R.id.textViewRoomConfirmationArgument)).check(isCompletelyRightOf(withId(R.id.textViewRoomConfirmation)));
    }
    @Test
    public void DateConfirmationArgumentDisplayed() {
        onView(withId(R.id.textViewDateConfirmationArgument)).check(matches(isDisplayed()));
        onView(withId(R.id.textViewDateConfirmationArgument)).check(isCompletelyAbove(withId(R.id.textViewTimeConfirmationArgument)));
        onView(withId(R.id.textViewDateConfirmationArgument)).check(isCompletelyBelow(withId(R.id.textViewRoomConfirmationArgument)));
        onView(withId(R.id.textViewDateConfirmationArgument)).check(isCompletelyRightOf(withId(R.id.textViewDateConfirmation)));
    }
    @Test
    public void TimeConfirmationArgumentDisplayed() {
        onView(withId(R.id.textViewTimeConfirmationArgument)).check(matches(isDisplayed()));
        onView(withId(R.id.textViewTimeConfirmationArgument)).check(isCompletelyAbove(withId(R.id.returnToRoomSelectionButton)));
        onView(withId(R.id.textViewTimeConfirmationArgument)).check(isCompletelyBelow(withId(R.id.textViewDateConfirmationArgument)));
        onView(withId(R.id.textViewTimeConfirmationArgument)).check(isCompletelyRightOf(withId(R.id.textViewTimeConfirmation)));
    }

    @Test
    public void ReturnButtonDisplayedAndClickable() {
        onView(withId(R.id.returnToRoomSelectionButton)).check((matches(isDisplayed())));
        onView(withId(R.id.returnToRoomSelectionButton)).check(isCompletelyBelow(withId(R.id.textViewMessage)));
    }
}
