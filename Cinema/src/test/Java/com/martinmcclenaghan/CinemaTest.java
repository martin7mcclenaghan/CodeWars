package com.martinmcclenaghan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class CinemaTest {

    private int cardPrice;
    private int normalTicketPrice;
    private double cardDiscountPercentage;
    private int numberOfVisits;

    public CinemaTest(int cardPrice, int normalTicketPrice, double cardDiscountPercentage, int numberOfVisits) {
        this.cardPrice = cardPrice;
        this.normalTicketPrice = normalTicketPrice;
        this.cardDiscountPercentage = cardDiscountPercentage;
        this.numberOfVisits = numberOfVisits;
    }

    @Parameterized.Parameters
    public static Collection<Object> testConditions() {
        return Arrays.asList(new Object[][]{

                {500, 15, 0.9, 43},
                {100, 10, 0.95, 24},
                {0, 10, 0.95, 2},
                {250, 20, 0.9, 21},
                {500, 20, 0.9, 34},
                {2500, 20, 0.9, 135},

        });
    }

    @Test
    public void movieTest() {
        assertEquals(numberOfVisits, CinemaMain.movie(cardPrice, normalTicketPrice, cardDiscountPercentage));
    }


}