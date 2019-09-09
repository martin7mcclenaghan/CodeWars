package com.martinmcclenaghan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)

public class TribSequenceTest {

    private double[] begin;
    private int entries;
    private double[] answer;

    public TribSequenceTest(double[] begin, int entries, double[] answer) {
        this.begin = begin;
        this.entries = entries;
        this.answer = answer;
    }


    @Parameterized.Parameters
    public static Collection<Object> testConditions() {
        return Arrays.asList(new Object[][] {

                {new double[]{1, 1, 1},10,new double []{1,1,1,3,5,9,17,31,57,105}},
                {new double[]{0, 1, 1},10,new double []{0,1,1,2,4,7,13,24,44,81}},
                {new double[]{0,0,1},10, new double[]{0,0,1,1,2,4,7,13,24,44}},
                {new double[]{0,0,0},10, new double[] {0,0,0,0,0,0,0,0,0,0}},
                {new double[]{3,2,1},10, new double[] {3,2,1,6,9,16,31,56,103,190}},
                {new double[]{1,1,1},2, new double[]{1,1}},
                {new double[]{1,1,1},1, new double[]{1}},
                {new double[]{1,1,1},0, new double[0]},
                {new double [] {0.5,0.5,0.5}, 10, new double[]{0.5,0.5,0.5,1.5,2.5,4.5,8.5,15.5,28.5,52.5}},

    });
    }

    @Test
    public void simpleTribTest(){

        assertArrayEquals(answer, TribSequenceMain.tribonacciSimple(begin,entries),0);

    }

    @Test
    public void tribonacciStreamTest (){

        assertArrayEquals(answer, TribSequenceMain.tribonacciStream(begin,entries),0);
    }


    }
