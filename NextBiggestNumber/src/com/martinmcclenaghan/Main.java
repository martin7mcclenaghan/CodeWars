package com.martinmcclenaghan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        long begin = 414;
        char [] chars = Long.toString(begin).toCharArray();

        List<Integer> beginList = new ArrayList<>();

        //use Array List as can be changed more easily

        for(int i = 0; i < chars.length; i++){

            beginList.add(i,Character.getNumericValue(chars[i]));
        }

        System.out.println("Original List Reads");

        System.out.println(beginList.toString());

        //locate digit one

        int digitOneOriginalPosition = 0;
        boolean flag = false;

        for(int i = beginList.size()-1; i > 0; i--){

            if(beginList.get(i-1) < beginList.get(i)){

                digitOneOriginalPosition = i-1;
                flag = true;
                break;

            }
        }

        if(!flag){

            System.out.println(-1);
        }

        //locate digit 2
        //make smaller copy of array comprising D1 and all the digits to the right of it
        //final index is exclusive so no need to subtract 1

        int digitOne = beginList.get(digitOneOriginalPosition);

        //Manually create different sublist - using sublist method maintain one List object
        List<Integer> subList = new ArrayList<>();

        for(int i = digitOneOriginalPosition; i < beginList.size(); i++){

            subList.add(beginList.get(i));
        }

        Collections.sort(subList);

        //digit 2 will be to the immediate right of digit 1 BUT CANNOT BE EQUAL TO DIGIT ONE SO NEED TO COVER THAT
        int digitTwo = subList.get(subList.indexOf(digitOne) + 1);
        int i = 1;
        while (digitOne == digitTwo) {
            digitTwo = subList.get((subList.indexOf(digitOne) + 1 + i));
            i++;

        }

        //now find position of digitTwo in original arrayList
        // equals index in sublist to the right of D1 plus index of D1 in original list
        List<Integer> digitTwoList = beginList.subList(digitOneOriginalPosition, beginList.size());
        int digitTwoOriginalPosition = digitTwoList.indexOf(digitTwo) + digitOneOriginalPosition;
        System.out.println("Digit two position is " + digitOneOriginalPosition);

        System.out.println("Digit one equals " + digitOne);
        System.out.println("Digit one position is " + digitOneOriginalPosition);
        System.out.println("Digit two is " + digitTwo);
        System.out.println("Digit two position is " + digitTwoOriginalPosition);

        //swap D1 and D2 in original list
        Collections.swap(beginList,digitOneOriginalPosition,digitTwoOriginalPosition);

        System.out.println("List after swap reads ");
        System.out.println(beginList.toString());


        //now need to sort numbers to the right of D1 original position
        //numbers need to be sorted in descending order from the right ie; 128
        //can use sublist for this as we wanted changes to reflect back to original list

        List<Integer> descendingOrder = beginList.subList(digitOneOriginalPosition + 1, beginList.size());

        Collections.sort(descendingOrder);

        System.out.println("Answer should be");

        //need to convert back to char[] then string then Parse Long to avoid number format exception

        char[] answer = new char [beginList.size()];

        for(int j = 0; j < beginList.size(); j++){

            answer[j] = Character.forDigit(beginList.get(j),10);

        }

        String string = String.valueOf(answer);
        long qed = Long.parseLong(string);

        System.out.println(qed);



    }

    public static long nextBiggerNumber (long n){

        char [] chars = Long.toString(n).toCharArray();

        //Use char array as can get numeric values to then enter into ArrayList of Integers
        //Will also use ArrayList as can be manipulated more easily

        List<Integer> beginList = new ArrayList<>();
        for(int i = 0; i < chars.length; i++){

            beginList.add(i,Character.getNumericValue(chars[i]));
        }

        //locate digit one which is first integer that is not in ascending order
        // when digits are viewed from the right

        int digitOneOriginalPosition = 0;
        boolean flag = false;

        for(int i = beginList.size()-1; i > 0; i--){

            if(beginList.get(i-1) < beginList.get(i)){

                digitOneOriginalPosition = i-1;
                flag = true;
                break;

            }
        }

        int digitOne = beginList.get(digitOneOriginalPosition);

        //if digits are all in ascending order from the right (meaning all digits are in descending order when read
        // from the left then there is no larger number that can be made

        if(!flag){

            return -1;
        }

        //locate digit 2, which will be the next largest digit that is to the right of D1
        //D1 != D2
        //must create new ArrayList and not use sublist as we need a new instance
        //sublist merely gives a view of the original list and any changes will be reflected in both Lists

        List<Integer> subList = new ArrayList<>();
        for(int i = digitOneOriginalPosition; i < beginList.size(); i++){

            subList.add(beginList.get(i));
        }

        Collections.sort(subList);

        //D2 should now be to the immediate right of D1 but cannot be equal

        int digitTwo = subList.get(subList.indexOf(digitOne) + 1);
        int i = 1;
        while (digitOne == digitTwo) {
            digitTwo = subList.get((subList.indexOf(digitOne) + 1 + i));
            i++;

        }

        //now find position of digitTwo in original arrayList
        List<Integer> digitTwoList = beginList.subList(digitOneOriginalPosition, beginList.size());
        int digitTwoOriginalPosition = digitTwoList.indexOf(digitTwo) + digitOneOriginalPosition;

        //swap D1 and D2 in original list
        Collections.swap(beginList,digitOneOriginalPosition,digitTwoOriginalPosition);

        //now need to sort numbers to the right of D1's original position in ascending order eg. 128
        //can use sublist for this as we want the sort to also take place in the original list
        List<Integer> ascendingOrder = beginList.subList(digitOneOriginalPosition + 1, beginList.size());
        Collections.sort(ascendingOrder);

        //now need to convert back to long
        char[] answer = new char [beginList.size()];

        for(int j = 0; j < beginList.size(); j++){

            answer[j] = Character.forDigit(beginList.get(j),10);

        }

        return Long.parseLong(String.valueOf(answer));

    }




}
