package com.martinmcclenaghan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class HighestScoringWordTest {

    private String start;
    private String expected;

    public HighestScoringWordTest(String start, String expected) {
        this.start = start;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object> testConditions (){
        return Arrays.asList(new Object[][] {

                {"what time are we climbing up to the volcano", "volcano"},
                {"by the time i get to phoenix", "phoenix"},
                {"the result of an experiment", "experiment"}

        });
    }

    @Test
    public void highTest (){

        assertEquals(expected, HighestScoringWordMain.high(start));

    }
}
