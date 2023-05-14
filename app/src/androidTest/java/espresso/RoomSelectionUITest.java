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
import com.example.kad.RoomSelection;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class RoomSelectionUITest {
    @Rule
    public ActivityScenarioRule<RoomSelection> activityRule =
            new ActivityScenarioRule<>(RoomSelection.class);
    @Test
    public void Room1ButtonClickable() {
        onView(withId(R.id.room1)).perform(click());
    }
    @Test
    public void Room2ButtonClickable() {
        onView(withId(R.id.room2)).perform(click());
    }
    @Test
    public void Room3ButtonClickable() {
        onView(withId(R.id.room3)).perform(click());
    }

    @Test
    public void KADTitleIsDisplayed() {
        onView(withText("KAD Room Selection")).check(matches(isDisplayed()));
        onView(withText("KAD Room Selection")).check(isCompletelyAbove(withId(R.id.room1)));
    }

    @Test
    public void Room1ButtonDisplayed() {
        onView(withId(R.id.room1)).check(isCompletelyBelow(withText("KAD Room Selection")));
        onView(withId(R.id.room1)).check(isCompletelyAbove(withId(R.id.room2)));
        onView(withId(R.id.room1)).check(isCompletelyLeftOf(withId(R.id.textView)));
    }
    @Test
    public void Room2ButtonDisplayed() {
        onView(withId(R.id.room2)).check(isCompletelyBelow(withId(R.id.room1)));
        onView(withId(R.id.room2)).check(isCompletelyAbove(withId(R.id.room3)));
        onView(withId(R.id.room2)).check(isCompletelyLeftOf(withId(R.id.textView3)));
    }
    @Test
    public void Room3ButtonDisplayed() {
        onView(withId(R.id.room3)).check(isCompletelyBelow(withId(R.id.room2)));
        onView(withId(R.id.room3)).check(isCompletelyLeftOf(withId(R.id.textView4)));
    }

    @Test
    public void ConferenceRoomTextDisplayed() {
        onView(withId(R.id.textView)).check(isCompletelyBelow(withText("KAD Room Selection")));
        onView(withId(R.id.textView)).check(isCompletelyAbove(withId(R.id.textView3)));
        onView(withId(R.id.textView)).check(isCompletelyRightOf(withId(R.id.room1)));
    }
    @Test
    public void ForestTextDisplayed() {
        onView(withId(R.id.textView3)).check(isCompletelyBelow(withId(R.id.textView)));
        onView(withId(R.id.textView3)).check(isCompletelyAbove(withId(R.id.textView4)));
        onView(withId(R.id.textView3)).check(isCompletelyRightOf(withId(R.id.room2)));
    }
    @Test
    public void OfficeTextDisplayed() {
        onView(withId(R.id.textView4)).check(isCompletelyBelow(withId(R.id.textView3)));
        onView(withId(R.id.textView4)).check(isCompletelyRightOf(withId(R.id.room3)));
    }
}