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

                {0,null},
                {-144, null},
                {7,null},
                {101,null},
                {8, new int []{2,3}},
                {81, new int [] {9,2}},
                {484, new int [] {22,2}},
                {175616, new int []{56,3}},
                {31640625, new int []{5625,2}},
                {274625, new int []{65,3}}



        });
    }

    @org.junit.Test
    public void isPerfectPower() {

        assertArrayEquals(expected, Main.isPerfectPower(input));
    }
}