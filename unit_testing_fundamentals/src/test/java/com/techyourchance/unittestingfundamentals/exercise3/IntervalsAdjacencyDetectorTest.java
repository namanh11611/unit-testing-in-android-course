package com.techyourchance.unittestingfundamentals.exercise3;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.techyourchance.unittestingfundamentals.example3.Interval;

public class IntervalsAdjacencyDetectorTest {

    // System under test
    IntervalsAdjacencyDetector SUT;

    @Before
    public void setup() {
        SUT = new IntervalsAdjacencyDetector();
    }

    // Interval 1 before interval 2, but not adjacent
    @Test
    public void isAdjacent_1beforeNotAdj2_falseReturned() {
        Interval interval1 = new Interval(1, 2);
        Interval interval2 = new Interval(4, 5);
        boolean result = SUT.isAdjacent(interval1, interval2);
        Assert.assertThat(result, CoreMatchers.is(false));
    }

    // Interval 1 before interval 2, adjacent
    @Test
    public void isAdjacent_1beforeAdj2_trueReturned() {
        Interval interval1 = new Interval(1, 2);
        Interval interval2 = new Interval(2, 5);
        boolean result = SUT.isAdjacent(interval1, interval2);
        Assert.assertThat(result, CoreMatchers.is(true));
    }

    // Interval 1 before interval 2, overlap
    @Test
    public void isAdjacent_1beforeOverlap2_falseReturned() {
        Interval interval1 = new Interval(1, 3);
        Interval interval2 = new Interval(2, 5);
        boolean result = SUT.isAdjacent(interval1, interval2);
        Assert.assertThat(result, CoreMatchers.is(false));
    }

    // Interval 1 cover interval 2
    @Test
    public void isAdjacent_1cover2_falseReturned() {
        Interval interval1 = new Interval(1, 10);
        Interval interval2 = new Interval(4, 5);
        boolean result = SUT.isAdjacent(interval1, interval2);
        Assert.assertThat(result, CoreMatchers.is(false));
    }

    // Interval 1 equals interval 2
    @Test
    public void isAdjacent_1equals2_falseReturned() {
        Interval interval1 = new Interval(1, 2);
        Interval interval2 = new Interval(1, 2);
        boolean result = SUT.isAdjacent(interval1, interval2);
        Assert.assertThat(result, CoreMatchers.is(false));
    }

    // Interval 1 is covered by interval 2
    @Test
    public void isAdjacent_1coveredBy2_falseReturned() {
        Interval interval1 = new Interval(1, 2);
        Interval interval2 = new Interval(0, 5);
        boolean result = SUT.isAdjacent(interval1, interval2);
        Assert.assertThat(result, CoreMatchers.is(false));
    }

    // Interval 1 after interval 2, overlap
    @Test
    public void isAdjacent_1afterOverlap2_falseReturned() {
        Interval interval1 = new Interval(3, 5);
        Interval interval2 = new Interval(1, 4);
        boolean result = SUT.isAdjacent(interval1, interval2);
        Assert.assertThat(result, CoreMatchers.is(false));
    }

    // Interval 1 after interval 2, adjacent
    @Test
    public void isAdjacent_1afterAdj2_trueReturned() {
        Interval interval1 = new Interval(5, 7);
        Interval interval2 = new Interval(4, 5);
        boolean result = SUT.isAdjacent(interval1, interval2);
        Assert.assertThat(result, CoreMatchers.is(true));
    }

    // Interval 1 after interval 2, but not adjacent
    @Test
    public void isAdjacent_1afterNotAdj2_falseReturned() {
        Interval interval1 = new Interval(8, 9);
        Interval interval2 = new Interval(4, 5);
        boolean result = SUT.isAdjacent(interval1, interval2);
        Assert.assertThat(result, CoreMatchers.is(false));
    }
}