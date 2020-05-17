package com.example.assistancecontrol;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.IsAnything.anything;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    public ArrayList<String> u18List =
            new ArrayList<String>() {
                {
                    add("Pérez, Pepito");
                    add("Torres, Antonio");
                    add("Márquez, Manolito");
                }
            };

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void changeSpinnerToU16Category() {
        for (int i=0; i < u18List.size(); i++) {
            onData(anything())
                    .inAdapterView(withId(R.id.nameslistview))
                    .atPosition(i)
                    .check(matches(withText(u18List.get(i))));
        }
    }
}
