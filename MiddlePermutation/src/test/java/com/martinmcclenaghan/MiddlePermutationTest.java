package com.martinmcclenaghan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)

public class MiddlePermutationTest {

    private String input;
    private String expectedOutput;

    public MiddlePermutationTest(String input, String expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<Object> testConditions (){
        return Arrays.asList(new Object[][]{

                {"abc", "bac"},
                {"abcdxgz", "dczxgba"},
                {"znejlvf", "ljzvnfe"},
                {"twxdkhcsfbjgunvmeyopz", "nmzyxwvutspokjhgfedcb"},
                {"mldsrjfhonzqbpyxvuce", "nzyxvusrqpomljhfedcb"}

        });
    }

    @Test
    public void findMidPerm() {
        assertEquals(expectedOutput, MiddlePermutationMain.findMidPerm(input));
    }
}