package com.martinmcclenaghan;

// https://www.codewars.com/kata/did-you-mean-dot-dot-dot/train/java - Did you mean...?

//To compare the Strings we will use the Wagner-Fischer Algorithm. This computes the edit distance
// or Levenshtein distance between the two Strings. The edit distance is the minimum number of operations
// needed to transform one String into another. The available operations are delete, insert and substitute.
// See below for references:

// Levenshtein distance - https://en.wikipedia.org/wiki/Levenshtein_distance
// Wagner - Fischer Algorithm - https://en.wikipedia.org/wiki/Wagner%E2%80%93Fischer_algorithm

public class DidYouMeanMain {

    public static void main(String[] args) {

        Dictionary fruits = new Dictionary(new String[]{"cherry", "pineapple", "melon", "strawberry", "raspberry"});

        System.out.println(fruits.findMostSimilar("stawbery"));
        System.out.println(fruits.findMostSimilar("berry"));

        Dictionary codeWars = new Dictionary(new String[]{"stars", "mars", "wars", "codec", "codewars"});
        System.out.println(codeWars.findMostSimilar("coddwars"));




    }
}
