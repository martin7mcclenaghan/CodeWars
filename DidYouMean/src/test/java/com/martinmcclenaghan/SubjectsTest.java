package com.martinmcclenaghan;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)

public class SubjectsTest extends BaseTest {

    private Dictionary subjects;

    public SubjectsTest(String misspeltWord, String expected) {
        super(misspeltWord, expected);
    }

    @org.junit.Before
    public void setup() {
        subjects = new Dictionary(new String[]{"Maths", "Geography", "History",
                "English", "French", "German", "Economics", "Science"});
    }

    @Parameterized.Parameters
    public static Collection<Object> testConditions() {
        return Arrays.asList(new Object[][]{

                {"germam", "German"},
                {"Exonomics", "Economics"},
                {"Pistory", "History"},
                {"Xeograghy", "Geography"},
                {"Englisch", "English"}


        });
    }

    @Override
    public void findMostSimilarTest() {

        assertEquals(expected, subjects.findMostSimilar(misspeltWord));

    }
}