package com.martinmcclenaghan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)

public class MainTest {

    private int[] start;
    private String respsonse;

    public MainTest(int[] start, String respsonse) {
        this.start = start;
        this.respsonse = respsonse;
    }

    @Parameterized.Parameters
    public static Collection<Object> testConditions (){
        return Arrays.asList(new Object[][]{

                {new int[]{25,25,50},"YES"},
                {new int[]{25,100},"NO"},
                {new int[]{25,25,25,25,50,100,50},"YES"},
                {new int[]{50,100,100}, "NO"},
                {new int[]{100,50,25,25}, "NO"}


        });
    }

    @Test
    public void ticketsTest(){
        assertEquals(respsonse,Main.tickets(start));
    }

}
