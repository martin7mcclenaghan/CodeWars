package com.martinmcclenaghan;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)

// Parameterised tests for first two methods
// different list and number of items per page will be used to test methods
// need to construct new instance of PaginationHelper for each test

public class PaginationHelperTest {

    private PaginationHelper<Integer> helper;
    private List<Integer> collection;
    private int itemsPerPage;
    private int expectedItemCount;
    private int expectedPageCount;

    public PaginationHelperTest(List<Integer> collection, int itemsPerPage, int expectedItemCount, int expectedPageCount) {
        this.collection = collection;
        this.itemsPerPage = itemsPerPage;
        this.expectedItemCount = expectedItemCount;
        this.expectedPageCount = expectedPageCount;
        System.out.println("Constructor has run");
    }

    @Before
    public void setup() {
       this.helper = new PaginationHelper <>(this.collection, this.itemsPerPage);
        System.out.println("Before runs here");

    }

    @Parameterized.Parameters
    public static Collection <Object> testConditions (){
        return Arrays.asList(new Object[][]{

                {Arrays.asList(1,2,3,4,5), 2, 5, 3},
                {Arrays.asList(1,2,3,4,5,6), 3, 6, 2},
                {Arrays.asList(1,2,3,4,5,6,7,8), 4, 8, 2},
                {Arrays.asList(1,2,3,4,5,6,7,8,9), 5, 9, 2},
                {Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14), 6, 14, 3}

                });
    }

    @Test
    public void itemCount() {

        assertEquals(expectedItemCount,helper.itemCount());
        System.out.println("ItemCount test run");
    }

    @Test
    public void pageCount() {

        assertEquals(expectedPageCount,helper.pageCount());
        System.out.println("PageCount test run");
    }


}