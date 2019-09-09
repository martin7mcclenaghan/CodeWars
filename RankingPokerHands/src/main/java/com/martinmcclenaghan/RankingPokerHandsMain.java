package com.martinmcclenaghan;

//https://www.codewars.com/kata/5739174624fc28e188000465 - ranking poker hands
//https://www.codewars.com/kata/586423aa39c5abfcec0001e6 - sortable poker hands
//low aces are currently being ignored - not at the moment
public class RankingPokerHandsMain {

    public static void main(String[] args) {

        PokerHand myHand = new PokerHand("2S 2H 4H 8S 4C");
        PokerHand oppHand = new PokerHand("7D 4D 4H 2C 2S");
        System.out.println("My hand is a " + myHand.getClassification() + " with value " + myHand.getValue());
        System.out.println("Opp hand is a " + oppHand.getClassification()  + " with value " + oppHand.getValue());
        System.out.println(myHand.compareWith(oppHand));



    }

}