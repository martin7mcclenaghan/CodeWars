package com.martinmcclenaghan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)

public class MainTest {

    private int[] input;
    private int expected;

    public MainTest(int[] input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object> testConditions() {
        return Arrays.asList((Object[]) new Object[][]{

                {new int[]{58, 10, -32, -22, 3, -4, 34}, 68},
                {new int[]{-8, 1, 7, -2, -3, 4, -2, 5}, 10},
                {new int[]{7, -7, 8, -2, 3, -2, 1, -1}, 9},
                {new int[]{-2, -1, 4, -2, 2, 3, -2}, 7},
                {new int[]{3, -4, 8, 7, -10, 19, -3}, 24}

        });
    }

    @Test
    public void maxContiguousSum() {

        assertEquals(expected, Main.maxContiguousSumAddition(input));
    }

    @Test
    public void maxContiguousSumAddition() {

        assertEquals(expected, Main.maxContiguousSum(input));
    }


}