package com.martinmcclenaghan;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class IsHandFlushTest {

    private String[] input;
    private boolean expected;

    public IsHandFlushTest(String[] input, boolean expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object> testConditions (){
        return Arrays.asList(new Object[][]{

                {new String [] {"2S", "4C", "2D", "AH", "QD"}, false},
                {new String []{"4D", "5D", "QD", "KD", "AD"}, true},
                {new String [] {"7S", "5H", "4C", "KS", "AC"}, false},
                {new String [] {"4H", "QH", "AH", "2H", "9H"}, true}


        });
    }

    @org.junit.Test
    public void checkIfFlush() {
    }
}