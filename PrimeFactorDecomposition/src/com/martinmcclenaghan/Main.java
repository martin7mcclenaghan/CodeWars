package com.martinmcclenaghan;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println(createAnswerString(primeFactors(7)));
        System.out.println(createAnswerString(primeFactors(30)));
        System.out.println(createAnswerString(primeFactors(86240)));
        System.out.println(createAnswerString(primeFactors(7775460)));




    }

    public static int[] primeDivide(int n) {


        int x;

        for (int i = 2; i <= n / 2; i++) {

            if (isPrime(i)) {

                if (n % i == 0) {

                    x = n / i;
                    return new int[]{i, x};
                }
            }

        }

        //this will never run as while loop doesnt allow prime number to be passed to primeDivide method
        return new int[]{0, 0};


    }


    public static boolean isPrime(int n) {

        for (int i = 2; i <= n / 2; i++) {

            if (n % i == 0) {

                return false;
            }
        }

        return true;
    }

    public static List<Integer> primeFactors (int n){

        ArrayList<Integer> answers = new ArrayList<>();
        int[] temp;

        while (!isPrime(n)) {
            //System.out.println("Start at beginning = " + n);

            temp = primeDivide(n);
            answers.add(temp[0]);
            // System.out.println(temp[0] + " added as a prime factor.");

            if(isPrime(temp[1])){

                answers.add(temp[1]);
            }

            n = temp[1];

        }

        return answers;



    }

    public static String createAnswerString (List<Integer> list){

        ArrayList <Integer> unique = new ArrayList<>();
        ArrayList<String> answerList = new ArrayList<>();

        for(int i : list){

            if(!unique.contains(i)){

                unique.add(i);
            }
        }


        for(int i : unique){

            int count = 0;

            for(int j : list){

                if(j == i){

                    count++;
                }

            }

            if(count == 0){

                break;
            } else if(count == 1){

                answerList.add("(" + i + ")");
            }else {
                answerList.add("(" + i + "**" + count + ")");
            }

        }

        return String.join("", answerList);

    }
}
