package com.martinmcclenaghan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)

public class PrimeFactorDecompositionTest {

    private int input;
    private String outputString;
    private int isPrimeInput;
    private boolean isPrimeExpected;

    public PrimeFactorDecompositionTest(int input, String outputString, int isPrimeInput, boolean isPrimeExpected) {
        this.input = input;
        this.outputString = outputString;
        this.isPrimeInput = isPrimeInput;
        this.isPrimeExpected = isPrimeExpected;
    }

    @Parameterized.Parameters
    public static Collection<Object> testConditions (){
        return Arrays.asList(new Object[][]{

                {1,"N must be greater than 1", 11, true},
                {483499306, "(2)(41**2)(143813)", 4, false},
                {782611830, "(2)(3**2)(5)(7**2)(11)(13)(17)(73)", 163, true},
                {933555431, "(7537)(123863)", 131071, true},
                {7919, "(7919)", 6700417, true},


        });


    }

    @Test
    public void ladderTest (){

        assertEquals(outputString, PrimeFactorDecomposition.ladder(input));
    }

    @Test
    public void isPrimeTest (){

        assertEquals(isPrimeExpected, PrimeFactorDecomposition.isPrime(isPrimeInput));
    }


}

