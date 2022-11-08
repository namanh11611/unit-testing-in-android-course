package com.techyourchance.unittestingfundamentals.exercise1;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NegativeNumberValidatorTest {

    // System under test
    NegativeNumberValidator SUT;

    @Before
    public void setup() {
        SUT = new NegativeNumberValidator();
    }

    @Test
    public void test1() {
        boolean result = SUT.isNegative(-1);
        Assert.assertThat(result, CoreMatchers.is(true));
    }

    @Test
    public void test2() {
        boolean result = SUT.isNegative(0);
        Assert.assertThat(result, CoreMatchers.is(false));
    }

    @Test
    public void test3() {
        boolean result = SUT.isNegative(1);
        Assert.assertThat(result, CoreMatchers.is(false));
    }

}