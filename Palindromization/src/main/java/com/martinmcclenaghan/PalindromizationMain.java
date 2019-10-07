package com.martinmcclenaghan;

public class PalindromizationMain {

    // https://www.codewars.com/kata/palindromization/train/java 6kyu

    public static void main(String[] args) {

        String s1 = "123";
        System.out.println(palindromization(s1, 5));
        System.out.println(palindromization(s1, 6));

    }

    public static String palindromization(String elements, int n) {

        char[] elementsArray = elements.toCharArray();

        if (elements.isBlank() || n < 2) {
            return "elements string cannot be < 2";
        }

        StringBuilder stringBuilder = new StringBuilder();

        if (n == 2) {
            stringBuilder.append(elementsArray[0]);
            stringBuilder.append(elementsArray[0]);
            return stringBuilder.toString();
        }

        // if even
        if (n % 2 == 0) {
            char[] leftSide = new char[n / 2];
            char[] rightSide = new char[n / 2];
            int count = 0;

            for (int i = 0; i < leftSide.length; i++) {

                if (count == elementsArray.length) {
                    count = 0;
                }

                leftSide[i] = elementsArray[count];
                count++;

            }

            int rightSideCount = rightSide.length - 1;

            for (char c : leftSide) {

                rightSide[rightSideCount] = c;
                rightSideCount -= 1;
            }

            stringBuilder.append(String.valueOf(leftSide));
            stringBuilder.append(String.valueOf(rightSide));
            return stringBuilder.toString();

        } else {

            //else deals with n is odd number
            // middle term = n/2 + 1
            char[] leftSide = new char[(n / 2) + 1];
            char[] rightSide = new char[n / 2];

            int count = 0;

            for (int i = 0; i < leftSide.length; i++) {

                if (count == elementsArray.length) {
                    count = 0;
                }

                leftSide[i] = elementsArray[count];
                count++;

            }

            int rightSideCount = rightSide.length - 1;

            for (int i = 0; i < leftSide.length - 1; i++) {

                rightSide[rightSideCount] = leftSide[i];
                rightSideCount -= 1;
            }

            stringBuilder.append(String.valueOf(leftSide));
            stringBuilder.append(String.valueOf(rightSide));
            return stringBuilder.toString();


        }

    }
}
