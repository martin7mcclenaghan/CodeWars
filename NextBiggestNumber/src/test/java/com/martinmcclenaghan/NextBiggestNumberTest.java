package com.martinmcclenaghan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)

public class NextBiggestNumberTest {

    private long input;
    private long expectedAnswer;

    public NextBiggestNumberTest(long input, long expectedAnswer) {
        this.input = input;
        this.expectedAnswer = expectedAnswer;
    }

    @Parameterized.Parameters
    public static Collection<Object> testConditions(){
        return Arrays.asList(new Object [][] {

                {12, 21},
                {513, 531},
                {2017, 2071},
                {414, 441},
                {144, 414},
                {123456789, 123456798},
                {1234567890, 1234567908},
                {9876543210L, -1},
                {9999999999L, -1},
                { 59884848459853L, 59884848483559L}
        });
    }

    @Test
    public void nextBiggerNumber() {

        assertEquals(expectedAnswer, NextBiggestNumberMain.nextBiggerNumber(input));
    }
}