package com.martinmcclenaghan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        long begin = 32841;
        char [] chars = Long.toString(begin).toCharArray();

        List<Integer> beginList = new ArrayList<>();

        //use Array List as can be changed more easily

        for(int i = 0; i < chars.length; i++){

            beginList.add(i,Character.getNumericValue(chars[i]));
        }

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

        //digit 2 will be to the immediate right of digit 1
        int digitTwo = subList.get(subList.indexOf(digitOne) + 1);

        //now find position of digitTwo in original arrayList
        int digitTwoOriginalPosition = beginList.indexOf(digitTwo);

        //swap D1 and D2 in original list
        Collections.swap(beginList,digitOneOriginalPosition,digitTwoOriginalPosition);

        //now need to sort numbers to the right of D1 original position
        //numbers need to be sorted in descending order from the right ie; 128
        //can use sublist for this as we wanted changes to reflect back to original list

        List<Integer> descendingOrder = beginList.subList(digitOneOriginalPosition + 1, beginList.size());

        Collections.sort(descendingOrder);
        Collections.reverse(descendingOrder);

        System.out.println("Answer should be");

        for(Integer i : beginList){

            System.out.println(i);
        }




    }
}
