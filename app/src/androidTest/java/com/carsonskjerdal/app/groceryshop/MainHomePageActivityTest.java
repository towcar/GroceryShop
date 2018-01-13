package com.carsonskjerdal.app.groceryshop;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Carson on 2018-01-13.
 * <p>
 * Feel free to use code just give credit please :)
 */

@RunWith(AndroidJUnit4.class)
public class MainHomePageActivityTest {

    @Rule
    public ActivityTestRule<MainHomePageActivity> activityTestRule = new ActivityTestRule<>(MainHomePageActivity.class);

    @Test
    public void TestItems(){

        //check shopButton is visible
        Espresso.onView(withId(R.id.shop_button)).check(matches((isDisplayed())));

    }
}
