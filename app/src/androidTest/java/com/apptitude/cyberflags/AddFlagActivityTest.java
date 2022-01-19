package com.apptitude.cyberflags;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.not;


public class AddFlagActivityTest {

    @Rule
    public ActivityTestRule<AddFlagActivity> activityTestRule=new ActivityTestRule<AddFlagActivity>(AddFlagActivity.class);

    private AddFlagActivity addFlagActivity=null;

    @Before
    public void setUp() throws Exception {
        addFlagActivity=activityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){
        onView(withText(startsWith("Flagged"))).
                inRoot(withDecorView(
                        not(is(addFlagActivity.
                                getWindow().getDecorView())))).
                check(matches(isDisplayed()));
    }

    @After
    public void tearDown() throws Exception {
    }
}