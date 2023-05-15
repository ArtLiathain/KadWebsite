package espresso;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.runner.AndroidJUnit4;

import com.example.kad.AuthLogic;
import com.example.kad.activities.MainActivity;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class AccessibilityTest {
    AuthLogic authLogic = new AuthLogic();


    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<MainActivity>(MainActivity.class);


    @Test
    public void titleIsDisplayed(){
        onView(withText("KAD Room Booking System")).check(matches(isDisplayed()));
    }

    @Test
    public void testColorAccessibility() {
        int[] color1 = {255, 255, 255}; // White
        int[] color2 = {98, 0, 237}; // Purpule used in app
        int[] color3 = {0, 0, 0}; // Black
        boolean result1 = authLogic.colorAccessibility(color1, color1); // White and White
        boolean result2 = authLogic.colorAccessibility(color1, color2); // White and Purple (Colors used in app)
        boolean result3 = authLogic.colorAccessibility(color1,color3); // White and Black
        // Assert that the result should be true since the contrast ratio is greater than 4.5
        Assert.assertFalse(result1);
        Assert.assertTrue(result2);
        Assert.assertTrue(result3);
    }



}
