package com.example.mipt_3_praktinis;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import org.junit.Rule;
import org.junit.Test;

public class MainActivityUITest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void Given_BasicAddition_When_buttonsArePressed_Then_DisplaysCorrectResult() {
        onView(withId(R.id.btnOne)).perform(click());
        onView(withId(R.id.btnPlus)).perform(click());
        onView(withId(R.id.btnTwo)).perform(click());
        onView(withId(R.id.btnEquals)).perform(click());

        onView(withId(R.id.tvSolution)).check(matches(withText("3")));
    }

    @Test
    public void Given_SubtractionExpression_When_buttonsArePressed_Then_DisplaysCorrectResult() {
        onView(withId(R.id.btnFive)).perform(click());
        onView(withId(R.id.btnMinus)).perform(click());
        onView(withId(R.id.btnThree)).perform(click());
        onView(withId(R.id.btnEquals)).perform(click());

        onView(withId(R.id.tvSolution)).check(matches(withText("2")));
    }

    @Test
    public void Given_MultiplicationExpression_When_buttonsArePressed_Then_DisplaysCorrectResult() {
        onView(withId(R.id.btnFour)).perform(click());
        onView(withId(R.id.btnMultiply)).perform(click());
        onView(withId(R.id.btnTwo)).perform(click());
        onView(withId(R.id.btnEquals)).perform(click());

        onView(withId(R.id.tvSolution)).check(matches(withText("8")));
    }

    @Test
    public void Given_DivisionExpression_When_buttonsArePressed_Then_DisplaysCorrectResult() {
        onView(withId(R.id.btnNine)).perform(click());
        onView(withId(R.id.btnDivide)).perform(click());
        onView(withId(R.id.btnThree)).perform(click());
        onView(withId(R.id.btnEquals)).perform(click());

        onView(withId(R.id.tvSolution)).check(matches(withText("3")));
    }

    @Test
    public void Given_ClickOnClearButton_When_pressed_Then_DisplaysZero() {
        onView(withId(R.id.btnOne)).perform(click());
        onView(withId(R.id.btnC)).perform(click());

        onView(withId(R.id.tvSolution)).check(matches(withText("0")));
    }

    @Test
    public void Given_ExpressionWithMultipleOperators_When_buttonsArePressed_Then_DisplaysCorrectResult() {
        onView(withId(R.id.btnThree)).perform(click());
        onView(withId(R.id.btnPlus)).perform(click());
        onView(withId(R.id.btnTwo)).perform(click());
        onView(withId(R.id.btnMultiply)).perform(click());
        onView(withId(R.id.btnTwo)).perform(click());
        onView(withId(R.id.btnEquals)).perform(click());

        onView(withId(R.id.tvSolution)).check(matches(withText("7")));
    }

    @Test
    public void Given_InvalidDivisionExpression_When_buttonsArePressed_Then_DisplaysError() {
        onView(withId(R.id.btnThree)).perform(click());
        onView(withId(R.id.btnDivide)).perform(click());
        onView(withId(R.id.btnZero)).perform(click());
        onView(withId(R.id.btnEquals)).perform(click());

        onView(withId(R.id.tvSolution)).check(matches(withText("Error")));
    }

    @Test
    public void Given_ExpressionWithDecimalPoints_When_buttonsArePressed_Then_DisplaysCorrectResult() {
        onView(withId(R.id.btnOne)).perform(click());
        onView(withId(R.id.btnDot)).perform(click());
        onView(withId(R.id.btnFive)).perform(click());
        onView(withId(R.id.btnPlus)).perform(click());
        onView(withId(R.id.btnTwo)).perform(click());
        onView(withId(R.id.btnDot)).perform(click());
        onView(withId(R.id.btnFive)).perform(click());
        onView(withId(R.id.btnEquals)).perform(click());

        onView(withId(R.id.tvSolution)).check(matches(withText("4")));
    }

    @Test
    public void Given_LargeNumberExpression_When_buttonsArePressed_Then_DisplaysCorrectResult() {
        onView(withId(R.id.btnOne)).perform(click());
        onView(withId(R.id.btnZero)).perform(click());
        onView(withId(R.id.btnZero)).perform(click());
        onView(withId(R.id.btnMultiply)).perform(click());
        onView(withId(R.id.btnOne)).perform(click());
        onView(withId(R.id.btnZero)).perform(click());
        onView(withId(R.id.btnZero)).perform(click());
        onView(withId(R.id.btnEquals)).perform(click());

        onView(withId(R.id.tvSolution)).check(matches(withText("10000")));
    }

    @Test
    public void Given_EmptyExpression_When_noButtonsArePressed_Then_DisplaysZero() {
        onView(withId(R.id.tvSolution)).check(matches(withText("0")));
    }

    @Test
    public void Given_ExpressionWithNegativeNumbers_When_buttonsArePressed_Then_DisplaysCorrectResult() {
        onView(withId(R.id.btnMinus)).perform(click());
        onView(withId(R.id.btnFive)).perform(click());
        onView(withId(R.id.btnPlus)).perform(click());
        onView(withId(R.id.btnThree)).perform(click());
        onView(withId(R.id.btnEquals)).perform(click());

        onView(withId(R.id.tvSolution)).check(matches(withText("-2")));
    }

    @Test
    public void Given_ClickOnClearButtonMultipleTimes_When_Pressed_Then_DisplaysZero() {
        onView(withId(R.id.btnOne)).perform(click());
        onView(withId(R.id.btnC)).perform(click());
        onView(withId(R.id.btnC)).perform(click());

        onView(withId(R.id.tvSolution)).check(matches(withText("0")));
    }

    @Test
    public void Given_LargeExpressionWithMultipleOperators_When_Pressed_Then_DisplaysCorrectResult() {
        onView(withId(R.id.btnOne)).perform(click());
        onView(withId(R.id.btnPlus)).perform(click());
        onView(withId(R.id.btnTwo)).perform(click());
        onView(withId(R.id.btnMultiply)).perform(click());
        onView(withId(R.id.btnThree)).perform(click());
        onView(withId(R.id.btnMinus)).perform(click());
        onView(withId(R.id.btnFour)).perform(click());
        onView(withId(R.id.btnDivide)).perform(click());
        onView(withId(R.id.btnTwo)).perform(click());

        onView(withId(R.id.btnEquals)).perform(click());

        onView(withId(R.id.tvSolution)).check(matches(withText("5")));
    }

    @Test
    public void Given_ExpressionWithMultipleNegativeNumbers_When_Pressed_Then_DisplaysCorrectResult() {
        onView(withId(R.id.btnMinus)).perform(click());
        onView(withId(R.id.btnFive)).perform(click());
        onView(withId(R.id.btnPlus)).perform(click());
        onView(withId(R.id.btnMinus)).perform(click());
        onView(withId(R.id.btnThree)).perform(click());

        onView(withId(R.id.btnEquals)).perform(click());

        onView(withId(R.id.tvSolution)).check(matches(withText("-8")));
    }

}
