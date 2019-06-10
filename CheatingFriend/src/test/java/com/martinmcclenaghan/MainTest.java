package com.martinmcclenaghan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)

public class MainTest {

    private long input;
    private List<long[]> answer;

    public MainTest(long input, List<long[]> answer) {
        this.input = input;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection<Object> testConditions() {
        return Arrays.asList(new Object[][]{

                {100, new ArrayList<long[]>()},
                {1000003, Arrays.asList(new long[]{550320, 908566}, new long[]{559756, 893250},
                        new long[]{893250, 559756}, new long[]{908566, 550320})},
                {1000008, Arrays.asList(new long[]{677076, 738480}, new long[]{738480, 677076})},
                {101, Arrays.asList(new long[]{55, 91}, new long[]{91, 55})},
                {1006, Arrays.asList(new long[]{546, 925}, new long[]{925, 546})},
                {846, Arrays.asList(new long[]{498, 717}, new long[]{717, 498})},
                {446, Arrays.asList(new long[]{252, 393}, new long[]{393, 252})},
        });
    }

    @Test
    public void removeTest() {

        for(int i = 0; i < answer.size(); i++){

            assertArrayEquals(answer.get(i), Main.remove(input).get(i));
        }
    }
}