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

public class FurtherPaginationHelperTests {

    private PaginationHelper<Integer> helper;
    private List<Integer> collection;
    private int itemsPerPage;
    private int pageItemCountInput;
    private int itemIndexInput;
    private int expectedPageItemCount;
    private int expectedItemIndex;


    public FurtherPaginationHelperTests(List<Integer> collection, int itemsPerPage, int pageItemCountInput, int itemIndexInput, int expectedPageItemCount, int expectedItemIndex) {
        this.collection = collection;
        this.itemsPerPage = itemsPerPage;
        this.pageItemCountInput = pageItemCountInput;
        this.itemIndexInput = itemIndexInput;
        this.expectedPageItemCount = expectedPageItemCount;
        this.expectedItemIndex = expectedItemIndex;
    }

    @Before
    public void setup() {
        this.helper = new PaginationHelper <>(this.collection, this.itemsPerPage);
        System.out.println("Before runs here");

    }

    @Parameterized.Parameters
    public static Collection <Object> testConditions (){
        return Arrays.asList(new Object[][]{

                {Arrays.asList(1,2,3,4,5), 2, },
                {Arrays.asList(1,2,3,4,5,6), 3, },
                {Arrays.asList(1,2,3,4,5,6,7,8), 4},
                {Arrays.asList(1,2,3,4,5,6,7,8,9), 5},
                {Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14), 6}

        });
    }

    @Test
    public void pageItemCount(){


    }

    @Test
    public void itemIndex (){


    }



}
