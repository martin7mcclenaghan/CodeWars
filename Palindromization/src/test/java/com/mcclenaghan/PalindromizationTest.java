package com.mcclenaghan;

import com.martinmcclenaghan.PalindromizationMain;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PalindromizationTest {

    private String inputString;
    private int length;
    private String expected;

    public PalindromizationTest(String inputString, int length, String expected) {
        this.inputString = inputString;
        this.length = length;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object> testConditions (){
        return Arrays.asList(new Object[][] {

                {"abcd", 2, "aa"},
                {"abcd", 3, "aba"},
                {"abcd", 4, "abba"},
                {"abcd", 5, "abcba"},
                {"abcd", 6, "abccba"},
                { " ", 3, "elements string cannot be < 2"},
                {"abcd", 1, "elements string cannot be < 2"},



        });
    }

    @Test
    public void palindromizationTest (){

        assertEquals(expected, PalindromizationMain.palindromization(inputString, length));

    }
}
