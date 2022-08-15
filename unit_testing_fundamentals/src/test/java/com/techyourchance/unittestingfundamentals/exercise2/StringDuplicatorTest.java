package com.techyourchance.unittestingfundamentals.exercise2;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringDuplicatorTest {

    StringDuplicator SUT;

    @Before
    public void setup() {
        SUT = new StringDuplicator();
    }

    @Test
    public void test_emptyString_emptyStringReturned() {
        String result = SUT.duplicate("");
        Assert.assertThat(result, CoreMatchers.is(""));
    }

    @Test
    public void test_normalString_duplicateStringReturned() {
        String result = SUT.duplicate("This is test");
        Assert.assertThat(result, CoreMatchers.is("This is testThis is test"));
    }

}