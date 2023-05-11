package espresso;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.example.kad.RoomSelection;

import org.junit.Rule;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class EspressoRoomSelTest {
    @Rule
    public ActivityScenarioRule<RoomSelection> activityRule =
            new ActivityScenarioRule<RoomSelection>(RoomSelection.class);

//    @Test
//    public void room_sel_buttons(){
//        onView(withId(R.id.room1)).check(isCompletelyLeftOf(R.id.textView));
//    }

}
