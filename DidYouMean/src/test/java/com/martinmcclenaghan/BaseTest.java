package com.martinmcclenaghan;

import org.junit.Test;

public abstract class BaseTest {

   String mispeltWord;
   String expected;

    public BaseTest(String misspeltWord, String expected) {
        this.mispeltWord = misspeltWord;
        this.expected = expected;
    }

    @Test
    public abstract void findMostSimilarTest ();


}