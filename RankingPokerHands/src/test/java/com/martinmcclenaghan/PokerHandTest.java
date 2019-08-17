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
                {PokerHand.Result.WIN, "2H 3H 4H 5H 6H", "AS AD AC AH JD"},
                {PokerHand.Result.WIN,"AS AH 2H AD AC", "JS JD JC JH 3D"},
                {PokerHand.Result.LOSS,"2S AH 2H AS AC", "JS JD JC JH AD"},
                {PokerHand.Result.WIN, "AS 3S 4S 8S 2S", "2H 3H 5H 6H 7H"},
                {PokerHand.Result.WIN, "2H 3H 5H 6H 7H", "2S 3H 4H 5S 6C"},
                {PokerHand.Result.TIE, "2S 3H 4H 5S 6C", "3D 4C 5H 6H 2S"},
                {PokerHand.Result.WIN, "2S 3H 4H 5S 6C", "AH AC 5H 6H AS"},
                {PokerHand.Result.LOSS, "2S 2H 4H 5S 4C", "AH AC 5H 6H AS"},
                {PokerHand.Result.WIN, "2S 2H 4H 5S 4C", "AH AC 5H 6H 7S"},
                {PokerHand.Result.LOSS, "6S AD 7H 4S AS", "AH AC 5H 6H 7S"},
                {PokerHand.Result.LOSS, "2S AH 4H 5S KC", "AH AC 5H 6H 7S"},
                {PokerHand.Result.LOSS, "2S 3H 6H 7S 9C", "7H 3C TH 6H 9S"},
                {PokerHand.Result.WIN, "4S 5H 6H TS AC", "3S 5H 6H TS AC"},
                {PokerHand.Result.TIE, "2S AH 4H 5S 6C", "AD 4C 5H 6H 2C"}

        });
    }

    @Test
    public void compareWith() {
        PokerHand playerHand = new PokerHand(playerDescription);
        PokerHand opponentHand = new PokerHand(opponentDescription);
        assertEquals(expectedResult, playerHand.compareWith(opponentHand));

    }


}