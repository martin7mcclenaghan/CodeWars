package com.martinmcclenaghan;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FoodTest extends BaseTest {

    private Dictionary foods;

    public FoodTest(String misspeltWord, String expected) {
        super(misspeltWord, expected);
    }

    @org.junit.Before
    public void setup() {

        foods = new Dictionary(new String[]{"Ham", "Cheese", "Bacon", "Pork", "Beef", "Lamb", "Lettuce"});
    }

    @Parameterized.Parameters
    public static Collection<Object> testConditions() {
        return Arrays.asList(new Object[][]{

                {"Hom", "Ham"},
                {"Chezze", "Cheese"},
                {"Baconz", "Bacon"},
                {"Lamm", "Lamb"},
                {"Lettis", "Lettuce"}

        });
    }

    @Override
    public void findMostSimilarTest() {

        assertEquals(expected, foods.findMostSimilar(mispeltWord));

    }
}
