package com.martinmcclenaghan;
// https://www.codewars.com/kata/paginationhelper/train/java- Pagination Helper Challenge

import java.util.Arrays;

public class PaginationHelperMain {

    public static void main(String[] args) {

        PaginationHelper<Character> memoirs = new PaginationHelper<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);

        memoirs.printList();

        System.out.println("Total number of pages is " + memoirs.pageCount());
        System.out.println("Total number of items is " + memoirs.itemCount());

        int pageIndex = 0;
        System.out.println("Number of items on " + pageIndex + " is " + memoirs.pageItemCount(pageIndex));
        pageIndex = 1;
        System.out.println("Number of items on " + pageIndex + " is " + memoirs.pageItemCount(pageIndex));
        pageIndex = 2;
        System.out.println("Number of items on " + pageIndex + " is " + memoirs.pageItemCount(pageIndex));

        //item number is zero indexed;
        int itemNo = 0;
        System.out.println("Item number " + itemNo + " is on page " + memoirs.itemIndex(itemNo));
        itemNo = 1;
        System.out.println("Item number " + itemNo + " is on page " + memoirs.itemIndex(itemNo));
        itemNo = 2;
        System.out.println("Item number " + itemNo + " is on page " + memoirs.itemIndex(itemNo));
        itemNo = 3;
        System.out.println("Item number " + itemNo + " is on page " + memoirs.itemIndex(itemNo));
        itemNo = 4;
        System.out.println("Item number " + itemNo + " is on page " + memoirs.itemIndex(itemNo));
        itemNo = 5;
        System.out.println("Item number " + itemNo + " is on page " + memoirs.itemIndex(itemNo));
        itemNo = 6;
        System.out.println("Item number " + itemNo + " is on page " + memoirs.itemIndex(itemNo));

    }

}

