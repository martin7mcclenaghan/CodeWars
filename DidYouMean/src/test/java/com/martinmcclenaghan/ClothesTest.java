package com.martinmcclenaghan;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)

public class ClothesTest extends BaseTest {

    private Dictionary clothes;

    public ClothesTest(String misspeltWord, String expected) {
        super(misspeltWord, expected);
    }

    @Before
    public void setup() {

        clothes = new Dictionary(new String[]{"Shirt", "Tie", "Trainers", "Loafers", "Jeans", "Jacket", "Bowler Hat"});
    }

    @Parameterized.Parameters
    public static Collection<Object> testConditions() {
        return Arrays.asList(new Object[][]{

                {"Shift", "Shirt"},
                {"Tye", "Tie"},
                {"Jeanz", "Jeans"},
                {"Bawler Hat", "Bowler Hat"},
                {"Hacket", "Jacket"}
        });
    }

    @Override
    public void findMostSimilarTest() {

        assertEquals(expected, clothes.findMostSimilar(mispeltWord));

    }
}
