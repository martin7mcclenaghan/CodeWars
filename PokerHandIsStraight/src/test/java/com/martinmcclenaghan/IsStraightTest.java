package com.martinmcclenaghan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IsStraightTest {

    private int[] numbers;
    private ArrayList<Integer> hand;
    private boolean expected;

    public IsStraightTest(int[] numbers, boolean expected) {
        this.numbers = numbers;
        this.expected = expected;

        this.hand = new ArrayList<>();
        for (int i : numbers) {
            this.hand.add(i);
        }
    }

    @Parameterized.Parameters
    public static Collection<Object> testConditions() {
        return Arrays.asList((Object[]) new Object[][]{

                {new int[]{7, 7, 12, 11, 3, 4, 14}, false},
                {new int[]{4, 5, 6, 7, 8}, true},
                {new int []{2, 7, 12, 3, 4}, false},
                {new int[] {10, 14, 14 ,13, 12, 10, 11}, true},
                {new int[]{7, 8}, false}

        });
    }

    @Test
    public void isStraightTest() {
        assertEquals(expected, IsStraightMain.isStraight(this.hand));

    }


}
