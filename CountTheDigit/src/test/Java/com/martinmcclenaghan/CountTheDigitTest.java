package com.martinmcclenaghan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class CountTheDigitTest {

    private int number;
    private int digit;
    private int occurrences;

    public CountTheDigitTest(int number, int digit, int occurrences) {
        this.number = number;
        this.digit = digit;
        this.occurrences = occurrences;
    }

    @Parameterized.Parameters
    public static Collection<Object> testConditions() {
        return Arrays.asList(new Object[][]{

                {10, 1, 4},
                {25, 1, 11},
                {5750, 0, 4700},
                {11011, 2, 9481},
                {10576, 9, 7860},
                {14956, 1, 17267},
                {8304, 7, 3927},
                {12526, 1, 13558},

        });
    }

    @Test
    public void nbDigTest() {
        assertEquals(occurrences, CountTheDigitMain.nbDig(number, digit));
    }
}