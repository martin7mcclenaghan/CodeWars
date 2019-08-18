package com.martinmcclenaghan;

import java.util.*;

public class PokerHand {

    enum Result {WIN, LOSS, TIE}

    enum Strength {
        ROYAL_FLUSH,
        STRAIGHT_FLUSH,
        FOUR_OF_A_KIND,
        FULL_HOUSE,
        FLUSH,
        STRAIGHT,
        THREE_OF_A_KIND,
        TWO_PAIR,
        PAIR,
        HIGH_CARD,

    }

    private String description;
    private Strength classification;
    private int value;

    public PokerHand(String description) {
        this.description = description;
        this.classification = classifyHand(description);
        this.value = assignValue(this.classification);
    }

    public Strength getClassification() {
        return classification;
    }

    public int getValue() {
        return value;
    }

    public Result compareWith(PokerHand hand) {

        if (this.value > hand.value) {
            return Result.WIN;

        } else if (this.value < hand.value) {
            return Result.LOSS;

        } else if ((this.classification == Strength.ROYAL_FLUSH) || (this.classification == Strength.STRAIGHT_FLUSH)
                || (this.classification == Strength.STRAIGHT) || (this.classification == Strength.FLUSH)
                || (this.classification == Strength.HIGH_CARD)) {

            //here just check kicker or highest card
            System.out.println("checkKicker() invoked");
            return checkKicker(this.description, hand.description);

        } else if ((this.classification == Strength.FOUR_OF_A_KIND) || (this.classification == Strength.THREE_OF_A_KIND)
                || (this.classification == Strength.PAIR)) {

            System.out.println("checkSimplePair() invoked");
            return checkSimplePair(this.description, hand.description);

        } else if (this.classification == Strength.FULL_HOUSE) {

            System.out.println("fullHouseCompare() invoked");
            return fullHouseCompare(this.description, hand.description);

        } else {
            System.out.println("twoPairCompare() invoked");
            return twoPairCompare(this.description, hand.description);
        }
    }

    private int assignValue(Strength strength) {

        int strengthValue = 0;

        switch (strength) {

            case ROYAL_FLUSH:
                strengthValue = 10;
                break;

            case STRAIGHT_FLUSH:
                strengthValue = 9;
                break;

            case FOUR_OF_A_KIND:
                strengthValue = 8;
                break;

            case FULL_HOUSE:
                strengthValue = 7;
                break;

            case FLUSH:
                strengthValue = 6;
                break;

            case STRAIGHT:
                strengthValue = 5;
                break;

            case THREE_OF_A_KIND:
                strengthValue = 4;
                break;

            case TWO_PAIR:
                strengthValue = 3;
                break;

            case PAIR:
                strengthValue = 2;
                break;

            case HIGH_CARD:
                strengthValue = 1;
                break;
        }

        return strengthValue;
    }

    private Strength classifyHand(String description) {

        if (isRoyalFlush(description)) {
            return Strength.ROYAL_FLUSH;

        } else if (isStraight(description) && isFlush(description)) {
            return Strength.STRAIGHT_FLUSH;

        } else if (isFlush(description)) {
            return Strength.FLUSH;

        } else if (isStraight(description)) {
            return Strength.STRAIGHT;

        } else {
            return pairTypeHand(description);
        }


    }

    private String faceToNumber(String description) {
        String allNumbers = description.replaceAll("T", "10").replaceAll("J", "11")
                .replaceAll("Q", "12").replaceAll("K", "13")
                .replaceAll("A", "14");

        return allNumbers;
    }

    private List<Integer> listCardValues(String description) {

        String values = faceToNumber(description);

        String justValues = values.replaceAll("[A-Z]", ",").replaceAll("\\s+", "");

        String[] array = justValues.split(",");

        List<Integer> valueList = new ArrayList<>();

        for (String string : array) {

            valueList.add(Integer.parseInt(string));

        }

        Collections.sort(valueList);
        return valueList;

    }


    private Map<Integer, Integer> countUniqueTotals(List<Integer> cardValues) {

        Set<Integer> uniqueNumbers = new HashSet<>(cardValues);
        Map<Integer, Integer> totals = new HashMap<>();

        for (Integer i : uniqueNumbers) {

            int count = 0;

            for (Integer card : cardValues) {

                if (card.equals(i)) {
                    count++;
                }
            }

            totals.put(i, count);
        }

        return totals;
    }

    private Strength pairTypeHand(String description) {

        List<Integer> cardValues = listCardValues(description);
        Map<Integer, Integer> handTotals = countUniqueTotals(cardValues);

        ArrayList<Integer> pairs = new ArrayList<>(handTotals.values());
        int count = 0;

        if (pairs.contains(4)) {
            return Strength.FOUR_OF_A_KIND;

        } else if (pairs.contains(3) && pairs.contains(2)) {
            return Strength.FULL_HOUSE;

        } else if (pairs.contains(3)) {
            return Strength.THREE_OF_A_KIND;

        } else {
            for (Integer i : pairs) {

                if (i == 2) {
                    count++;
                }

            }

            if (count == 2) {
                return Strength.TWO_PAIR;
            } else if (count == 1) {
                return Strength.PAIR;
            } else {
                Collections.sort(pairs);
                return Strength.HIGH_CARD;
            }
        }
    }

    private boolean isFlush(String description) {

        String values = faceToNumber(description);
        char[] suits = values.replaceAll("[^A-Z]", "").toCharArray();
        boolean flag = true;

        for (int i = 0; i < suits.length - 1; i++) {

            if (suits[i] != suits[i + 1]) {
                flag = false;
                break;
            }
        }

        return flag;

    }

    private boolean isStraight(String description) {

        List<Integer> cards = listCardValues(description);

        //what we need is 5 cards in sequence
        int sequence = 1;

        for (int card : cards) {

            //deals with low ace
            if (cards.contains(2) && cards.contains(14)) {
                sequence++;
            }

            int nextCard = card + 1;

            while (cards.contains(nextCard)) {
                sequence++;
                nextCard++;

            }

            if (sequence >= 5) {
                return true;
            }

            //reset sequence for next card
            sequence = 1;
        }

        return false;


    }

    private boolean isRoyalFlush(String description) {

        if (isFlush(description) && isStraight(description)) {

            List<Integer> royalFlushValues = new ArrayList<>();
            royalFlushValues.add(10);
            royalFlushValues.add(11);
            royalFlushValues.add(12);
            royalFlushValues.add(13);
            royalFlushValues.add(14);

            return listCardValues(description).containsAll(royalFlushValues);

        }

        return false;

    }

    //method checks largest card value and is useful only for RF SF S, F and HC
    private Result checkKicker(String myDescription, String oppDescription) {

        List<Integer> handValues = listCardValues(myDescription);
        Collections.sort(handValues);
        List<Integer> opponentHandValues = listCardValues(oppDescription);
        Collections.sort(opponentHandValues);

        for(int i = 4; i >= 0; i--){

            int myKicker = handValues.get(i);
            int oppKicker = opponentHandValues.get(i);

            if (myKicker > oppKicker) {
                return Result.WIN;

            } else if (myKicker < oppKicker) {
                return Result.LOSS;
            }

        }

        return Result.TIE;

    }

    //method to compare hand and then kickers for Four, Three and Pair as there is only one major component
    private Result checkSimplePair(String myDescription, String oppDescription) {

        //check major component of the hand
        Map<Integer, List<Integer>> myHand = valuePairKickers(myDescription);
        Map<Integer, List<Integer>> oppHand = valuePairKickers(oppDescription);

        Integer[] myHighestCard = new Integer[1];
        myHand.keySet().toArray(myHighestCard);

        Integer[] oppHighestCard = new Integer[1];
        oppHand.keySet().toArray(oppHighestCard);


        if (myHighestCard[0] > oppHighestCard[0]) {
            return Result.WIN;

        } else if (myHighestCard[0] < oppHighestCard[0]) {
            return Result.LOSS;
        } else {

            List<Integer> myKickers = myHand.get(myHighestCard[0]);
            List<Integer> oppKickers = oppHand.get(oppHighestCard[0]);

            for (int i = myKickers.size() - 1; i >= 0; i--) {

                if (myKickers.get(i) > oppKickers.get(i)) {
                    return Result.WIN;

                } else if (myKickers.get(i) < oppKickers.get(i)) {
                    return Result.LOSS;
                }

            }

            return Result.TIE;
        }

    }

    // method returns major component of hand plus ArrayList of kickers in order
    private Map<Integer, List<Integer>> valuePairKickers(String description) {

        Map<Integer, Integer> pairs = countUniqueTotals(listCardValues(description));
        List<Integer> values = new ArrayList<>(pairs.values());
        Collections.sort(values);

        //will only be one major component as is only for pair, three of a kind and four of a kind
        //largest major component will win then will cycle through kickers if they are equal
        int greatestOccurrence = values.get(values.size() - 1);
        Integer cardGreatestOccurrence = 0;

        for (Integer key : pairs.keySet()) {

            if (pairs.get(key) == greatestOccurrence) {

                cardGreatestOccurrence = key;

            }
        }

        pairs.remove(cardGreatestOccurrence);
        List<Integer> kickers = new ArrayList<>(pairs.keySet());
        Collections.sort(kickers);

        Map<Integer, List<Integer>> answer = new HashMap<>();
        answer.put(cardGreatestOccurrence, kickers);
        return answer;

    }

    private Result fullHouseCompare(String myDescription, String oppDescription) {

        Map<Integer, Integer> myPairs = countUniqueTotals(listCardValues(myDescription));
        Map<Integer, Integer> oppPairs = countUniqueTotals(listCardValues(oppDescription));

        int myThreeCards = 0;
        int myTwoCards = 0;

        for (Integer card : myPairs.keySet()) {

            if (myPairs.get(card) == 3) {
                myThreeCards = card;

            } else {
                myTwoCards = card;
            }

        }

        int oppThreeCards = 0;
        int oppTwoCards = 0;

        for (Integer card : oppPairs.keySet()) {

            if (oppPairs.get(card) == 3) {
                oppThreeCards = card;

            } else {
                oppTwoCards = card;
            }

        }

        if (myThreeCards > oppThreeCards) {
            return Result.WIN;

        } else if (myThreeCards < oppThreeCards) {
            return Result.LOSS;

        } else {

            if (myTwoCards > oppTwoCards) {
                return Result.WIN;

            } else if (myTwoCards < oppTwoCards) {
                return Result.LOSS;
            } else {
                return Result.TIE;
            }
        }

    }

    private Result twoPairCompare(String myDescription, String oppDescription) {

        Map<Integer, Integer> myPairs = countUniqueTotals(listCardValues(myDescription));
        Map<Integer, Integer> oppPairs = countUniqueTotals(listCardValues(oppDescription));

        List<Integer> myPairList = new ArrayList<>();
        Integer myKicker = 0;
        for (Integer card : myPairs.keySet()) {

            if (myPairs.get(card) == 2) {
                myPairList.add(card);
            } else {
                myKicker = card;
            }
        }

        List<Integer> oppPairList = new ArrayList<>();
        Integer oppKicker = 0;
        for (Integer card : oppPairs.keySet()) {

            if (oppPairs.get(card) == 2) {
                oppPairList.add(card);
            } else {
                oppKicker = card;
            }

        }

        Collections.sort(myPairList);
        Collections.sort(oppPairList);

        if (myPairList.get(1) > oppPairList.get(1)) {
            return Result.WIN;

        } else if (myPairList.get(1) < oppPairList.get(1)) {
            return Result.LOSS;

        } else {

            if (myPairList.get(0) > oppPairList.get(0)) {
                return Result.WIN;

            } else if (myPairList.get(0) < oppPairList.get(0)) {
                return Result.LOSS;

            } else {

                if (myKicker > oppKicker) {
                    return Result.WIN;

                } else if (myKicker < oppKicker) {
                    return Result.LOSS;

                } else {
                    return Result.TIE;
                }
            }

        }


    }

}
