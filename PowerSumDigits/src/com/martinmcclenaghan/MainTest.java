package com.martinmcclenaghan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
@RunWith(Parameterized.class)

public class MainTest {

    private int input;
    private long expected;

    public MainTest(int input, long expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object> testConditions (){
        return Arrays.asList(new Object [][]{




        });
    }

    @Test
    public void powerSumDigTermTest (){
        assertEquals(expected, Main.powerSumDigTerm(input));
    }
}