package com.martinmcclenaghan;
//https://www.codewars.com/kata/next-smaller-number-with-the-same-digits/train/java - next smallest number with same digits

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NextSmallestNumberMain {

    public static void main(String[] args) {

        System.out.println(nextSmallerNumber(21));
        System.out.println(nextSmallerNumber(907));
        System.out.println(nextSmallerNumber(531));
        System.out.println(nextSmallerNumber(1027));
        System.out.println(nextSmallerNumber(441));
        System.out.println(nextSmallerNumber(123456798));




    }

    public static long nextSmallerNumber (long n){

        //when viewed from the right find a number not in descending order ie where L > R, this is Digit 1

        char [] chars = Long.toString(n).toCharArray();

        List<Integer> begin = new ArrayList<>();

        for (int i = 0; i < chars.length; i++){

            begin.add(i,Character.getNumericValue(chars[i]));

        }

        // now to locate Digit 1

        int digitOneOriginalPosition = 0;
        boolean flag = false;

        for (int i = begin.size() - 1; i > 0; i--){

            if(begin.get(i-1) > begin.get(i)){

                digitOneOriginalPosition = i-1;
                flag = true;
                break;
            }

        }

        int digitOne = begin.get(digitOneOriginalPosition);

        if(!flag){

            return -1;
        }

        //locate Digit 2, which is a number to the right of D1 such that it is the largest number smaller than D1
        //new ArrayList created as we do not want to change order of original list just yet

        List<Integer> smallerList = new ArrayList<>();

        for(int i = digitOneOriginalPosition; i < begin.size(); i++){

            smallerList.add(begin.get(i));
        }

        Collections.sort(smallerList);

        //D2 will now be to the immediate left of D1 but cannot be equal to it

        int digitTwo = smallerList.get(smallerList.indexOf(digitOne) -1);
        int i = 1;
        while (digitOne == digitTwo) {
            digitTwo = smallerList.get((smallerList.indexOf(digitOne) -1 - i));
            i++;

        }

        //now find position of D2 in original arrayList
        //use List.subList to avoid finding duplicates of D2 in original list

        List<Integer> digitTwoList = begin.subList(digitOneOriginalPosition, begin.size());
        int digitTwoOriginalPosition = digitTwoList.indexOf(digitTwo) + digitOneOriginalPosition;

        //swap D1 and D2 in original list
        Collections.swap(begin,digitOneOriginalPosition,digitTwoOriginalPosition);

        //sort numbers to the right of D1's original position in descending order eg. 721
        //use List.subList for this as we want the sort to also take place in the original list
        List<Integer> reOrder = begin.subList(digitOneOriginalPosition + 1, begin.size());
        Collections.sort(reOrder);

        //use reverse as we want numbers to be sorted in descending order
        Collections.reverse(reOrder);

        //solutions with leading zeros are not allowed
        if(begin.get(0) == 0){

            return -1;
        }

        char[] answer = new char [begin.size()];

        for(int j = 0; j < begin.size(); j++){

            answer[j] = Character.forDigit(begin.get(j),10);

        }

        return Long.parseLong(String.valueOf(answer));


    }

}

