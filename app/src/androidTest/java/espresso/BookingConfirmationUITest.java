package espresso;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
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

    }

}
