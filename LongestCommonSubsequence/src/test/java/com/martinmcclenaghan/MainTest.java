package com.martinmcclenaghan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
@RunWith(Parameterized.class)

public class MainTest {

    private String input1;
    private String input2;
    private String expected;

    public MainTest(String input1, String input2, String expected) {
        this.input1 = input1;
        this.input2 = input2;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object> testConditions (){
        return Arrays.asList(new Object[][]{



        });
    }

    @Test
    public void lcs() {
        assertEquals(expected, Main.lcs(input1,input2));
    }
}