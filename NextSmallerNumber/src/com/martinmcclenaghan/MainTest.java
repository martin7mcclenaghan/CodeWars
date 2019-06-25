package com.martinmcclenaghan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)

public class MainTest {

    private long input;
    private long expectedAnswer;

    public MainTest(long input, long expectedAnswer) {
        this.input = input;
        this.expectedAnswer = expectedAnswer;
    }

    @Parameterized.Parameters
    public static Collection<Object> testConditions(){
        return Arrays.asList(new Object [][] {

                {513, 351},
                {351, 315},
                {315, 153},
                {135, -1},
                {2071, 2017},
                {100, -1},
                {12345678, -1},
                {1234567908, 1234567890},
                {59884848483559L, 59884848459853L},
                { 202233445566L, -1}
        });
    }

    @Test
    public void nextSmallerNumber() {

        assertEquals(expectedAnswer, Main.nextSmallerNumber(input));
    }
}