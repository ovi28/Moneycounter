package com.counter.test.moneycounter;

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.TextView;


import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class EspressoTest {


    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void ensureAddTwentyWorks() {
        String text = getText(withId(R.id.tvTwenty));
        int amount = Integer.parseInt(text);
        amount++;
        onView(withId(R.id.bAddTwenty)).perform(click());
        onView(withId(R.id.tvTwenty)).check(matches(withText(""+amount)));
    }

    @Test
    public void ensureSubTwentyWorks() {
        String text = getText(withId(R.id.tvTwenty));
        int amount = Integer.parseInt(text);
        if(amount!=0)
        amount--;
        onView(withId(R.id.bSubTwenty)).perform(click());
        onView(withId(R.id.tvTwenty)).check(matches(withText(""+amount)));
    }

    @Test
    public void ensureAddTenWorks() {
        String text = getText(withId(R.id.tvTen));
        int amount = Integer.parseInt(text);
        amount++;
        onView(withId(R.id.bAddTen)).perform(click());
        onView(withId(R.id.tvTen)).check(matches(withText(""+amount)));
    }

    @Test
    public void ensureSubTenWorks() {
        String text = getText(withId(R.id.tvTen));
        int amount = Integer.parseInt(text);
        if(amount!=0)
            amount--;
        onView(withId(R.id.bSubTen)).perform(click());
        onView(withId(R.id.tvTen)).check(matches(withText(""+amount)));
    }
    @Test
    public void ensureAddFiveWorks() {
        String text = getText(withId(R.id.tvFive));
        int amount = Integer.parseInt(text);
        amount++;
        onView(withId(R.id.bAddFive)).perform(click());
        onView(withId(R.id.tvFive)).check(matches(withText(""+amount)));
    }

    @Test
    public void ensureSubFiveWorks() {
        String text = getText(withId(R.id.tvFive));
        int amount = Integer.parseInt(text);
        if(amount!=0)
            amount--;
        onView(withId(R.id.bSubFive)).perform(click());
        onView(withId(R.id.tvFive)).check(matches(withText(""+amount)));
    }
    @Test
    public void ensureAddTwoWorks() {
        String text = getText(withId(R.id.tvTwo));
        int amount = Integer.parseInt(text);
        amount++;
        onView(withId(R.id.bAddTwo)).perform(click());
        onView(withId(R.id.tvTwo)).check(matches(withText(""+amount)));
    }

    @Test
    public void ensureSubTwoWorks() {
        String text = getText(withId(R.id.tvTwo));
        int amount = Integer.parseInt(text);
        if(amount!=0)
            amount--;
        onView(withId(R.id.bSubTwo)).perform(click());
        onView(withId(R.id.tvTwo)).check(matches(withText(""+amount)));
    }
    @Test
    public void ensureAddOneWorks() {
        String text = getText(withId(R.id.tvOne));
        int amount = Integer.parseInt(text);
        amount++;
        onView(withId(R.id.bAddOne)).perform(click());
        onView(withId(R.id.tvOne)).check(matches(withText(""+amount)));
    }

    @Test
    public void ensureSubOneWorks() {
        String text = getText(withId(R.id.tvOne));
        int amount = Integer.parseInt(text);
        if(amount!=0)
            amount--;
        onView(withId(R.id.bSubOne)).perform(click());
        onView(withId(R.id.tvOne)).check(matches(withText(""+amount)));
    }
    @Test
    public void ensureAddPointFiveWorks() {
        String text = getText(withId(R.id.tvPointFive));
        int amount = Integer.parseInt(text);
        amount++;
        onView(withId(R.id.bAddPointFive)).perform(click());
        onView(withId(R.id.tvPointFive)).check(matches(withText(""+amount)));
    }

    @Test
    public void ensureSubPointFiveWorks() {
        String text = getText(withId(R.id.tvPointFive));
        int amount = Integer.parseInt(text);
        if(amount!=0)
            amount--;
        onView(withId(R.id.bSubPointFive)).perform(click());
        onView(withId(R.id.tvPointFive)).check(matches(withText(""+amount)));
    }



    private String getText(final Matcher<View> matcher) {
        final String[] stringHolder = { null };
        onView(matcher).perform(new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isAssignableFrom(TextView.class);
            }

            @Override
            public String getDescription() {
                return "getting text from a TextView";
            }

            @Override
            public void perform(UiController uiController, View view) {
                TextView tv = (TextView)view; //Save, because of check in getConstraints()
                stringHolder[0] = tv.getText().toString();
            }
        });
        return stringHolder[0];
    }


}