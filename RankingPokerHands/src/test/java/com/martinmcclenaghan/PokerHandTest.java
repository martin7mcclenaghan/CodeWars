package com.martinmcclenaghan;

import junit.framework.TestResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class PokerHandTest {

    private PokerHand.Result expectedResult;
    private String playerDescription;
    private String opponentDescription;

    public PokerHandTest(PokerHand.Result expectedResult, String playerDescription, String opponentDescription) {
        this.expectedResult = expectedResult;
        this.playerDescription = playerDescription;
        this.opponentDescription = opponentDescription;
    }

    @Parameterized.Parameters
    public static Collection<Object> testConditions (){
        return Arrays.asList(new Object[][]{

                {PokerHand.Result.LOSS, "2H 3H 4H 5H 6H", "KS AS TS QS JS"},

        });
    }

    @Test
    public void compareWith() {
        PokerHand playerHand = new PokerHand(playerDescription);
        PokerHand opponentHand = new PokerHand(opponentDescription);
        assertEquals(expectedResult, playerHand.compareWith(opponentHand));

    }


}