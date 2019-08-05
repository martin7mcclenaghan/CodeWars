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
        return Arrays.asList((Object[]) new Object [][]{

                {21, 27512614111L},
                {15, 60466176},
                {17, 612220032},
                {18, 8303765625L},
                {12, 17210368},
                {23, 68719476736L},
                {9, 390625},
                {23, 68719476736L},
                {10, 614656},
                {27, 6722988818432L}

        });
    }

    @Test
    public void powerSumDigTermTest (){
        assertEquals(expected, Main.powerSumDigTerm(input));
    }
}