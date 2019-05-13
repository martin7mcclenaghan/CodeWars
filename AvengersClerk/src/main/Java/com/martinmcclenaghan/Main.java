package com.martinmcclenaghan;

public class Main {

    //https://www.codewars.com/kata/vasya-clerk/train/java


        public static void main(String[] args) {

            int[] start = {25, 25, 25, 25, 50, 100, 50};

            System.out.println(Tickets(start));


        }

        public static String Tickets(int[] peopleInLine) {

            if (peopleInLine[0] != 25) {
                return "NO";
            }

            int small = 1; //number of 25 bills
            int med = 0; // 50 bills
            int large = 0; // 100 bills


            for (int i = 1; i < peopleInLine.length; i++) {

                System.out.println(peopleInLine[i]);

                switch (peopleInLine[i]) {

                    case 25:
                        //just takes 25 bill
                        small++;
                        break;

                    case 50:
                        //takes one 50 bill and gives back one 25 bill
                        med++;
                        small--;

                        if (small < 0) {
                            return "NO";
                        }
                        break;

                    case 100:
                        // check if have a 50 to give away first
                        if ((med >= 1) && (small >= 1)) {
                            small--;
                            med--;
                            large++;
                            break;

                        } else if (small >= 3) {
                            small -= 3;
                            large++;
                            break;

                        } else {
                            return "NO";
                        }

                }

                System.out.println("Small equals " + small);
                System.out.println("Med equals " + med);
                System.out.println("Large equals " + large);
            }

            return "YES";

        }

    }

