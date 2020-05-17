package com.example.assistancecontrol;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.IsAnything.anything;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    private ArrayList<String> u18List =
            new ArrayList<String>() {
                {
                    add("Pérez, Pepito");
                    add("Torres, Antonio");
                    add("Márquez, Manolito");
                }
            };

    private ArrayList<String> u16List =
            new ArrayList<String>() {
                {
                    add("Parquet, Paquito");
                    add("Alessandro, Jorge");
                    add("Márquez, Marc");
                }
            };

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void changeSpinnerToU16Category() {
        // Check that u18 choice is selected
        for (int i=0; i < u18List.size(); i++) {
            onData(anything())
                    .inAdapterView(withId(R.id.nameslistview))
                    .atPosition(i)
                    .check(matches(withText(u18List.get(i))));
        }
        // Click on u16 choice
        onView(withId(R.id.show_category_spinner))
                .perform(click());
        onData(anything()).atPosition(1).perform(click());
        // Check that u16 data is there
        for (int i=0; i < u16List.size(); i++) {
            onData(anything())
                    .inAdapterView(withId(R.id.nameslistview))
                    .atPosition(i)
                    .check(matches(withText(u16List.get(i))));
        }
    }
}
