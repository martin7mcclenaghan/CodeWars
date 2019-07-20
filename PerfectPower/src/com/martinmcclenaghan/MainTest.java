package com.martinmcclenaghan;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)

public class MainTest {

    private int input;
    private int[] expected;

    public MainTest(int input, int[] expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object> testConditions() {
        return Arrays.asList(new Object[][]{

                {}

        });
    }

    @org.junit.Test
    public void isPerfectPower() {
    }
}