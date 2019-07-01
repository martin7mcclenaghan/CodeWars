package com.martinmcclenaghan;

public abstract class BaseTest {

   String mispeltWord;
   String expected;

    public BaseTest(String mispeltWord, String expected) {
        this.mispeltWord = mispeltWord;
        this.expected = expected;
    }


}