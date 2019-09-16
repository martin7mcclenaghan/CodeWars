package com.martinmcclenaghan;

import org.junit.Test;

public abstract class BaseTest {

   String misspeltWord;
   String expected;

    public BaseTest(String misspeltWord, String expected) {
        this.misspeltWord = misspeltWord;
        this.expected = expected;
    }

    @Test
    public abstract void findMostSimilarTest ();


}