package espresso;

import android.view.View;
import android.view.WindowManager;

import androidx.test.espresso.Root;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class ToastMacher {

    public static Matcher<Root> isToast() {
        return new TypeSafeMatcher<Root>() {

            @Override
            public void describeTo(Description description) {
                description.appendText("is toast");
            }

            @Override
            protected boolean matchesSafely(Root root) {
                // Check if the root view is a Toast view
                int type = root.getWindowLayoutParams().get().type;
                if (type == WindowManager.LayoutParams.TYPE_TOAST) {
                    // Check if the root view is attached to the application window
                    View decorView = root.getDecorView();
                    return decorView.getWindowToken() != null && decorView.getWindowToken() != decorView.getApplicationWindowToken();
                }
                return false;
            }
        };
    }
}
