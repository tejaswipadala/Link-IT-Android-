package com.apptitude.cyberflags;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.RootMatchers;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Objects;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.junit.Assert.*;

import com.apptitude.cyberflags.R;

public class MediaActivityTest {

    @Rule
    public ActivityTestRule<MediaActivity> activityTestRule=new ActivityTestRule<MediaActivity>(MediaActivity.class);

    private MediaActivity mediaActivity=null;

    @Test
    public void testLaunch(){
        View view=mediaActivity.findViewById(R.id.floating_button);
        assertNotNull(view);

    }

    @Test
    public void testSampleRecyclerVisible() {
        Espresso.onView(ViewMatchers.withId(R.id.recyclerView))
                .inRoot(RootMatchers.withDecorView(
                        Matchers.is(mediaActivity.getWindow().getDecorView())))
                .check(matches(isDisplayed()));
    }

    @Test
    public void testCaseForRecyclerClick() {
        Espresso.onView(ViewMatchers.withId(R.id.recyclerView))
                .inRoot(RootMatchers.withDecorView(
                        Matchers.is(mediaActivity.getWindow().getDecorView())))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
    }

    @Test
    public void testCaseForRecyclerScroll() {

        // Get total item of RecyclerView
        RecyclerView recyclerView = mediaActivity.findViewById(R.id.recyclerView);
        int itemCount = Objects.requireNonNull(recyclerView.getAdapter()).getItemCount();

        // Scroll to end of page with position
        Espresso.onView(ViewMatchers.withId(R.id.recyclerView))
                .inRoot(RootMatchers.withDecorView(
                        Matchers.is(mediaActivity.getWindow().getDecorView())))
                .perform(RecyclerViewActions.scrollToPosition(itemCount - 1));
    }

    @Before
    public void setUp() throws Exception {
        mediaActivity=activityTestRule.getActivity();
    }

    @After
    public void tearDown() throws Exception {
    }
}