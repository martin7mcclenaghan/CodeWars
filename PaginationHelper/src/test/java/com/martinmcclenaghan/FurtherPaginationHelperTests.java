package com.martinmcclenaghan;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)

public class FurtherPaginationHelperTests {

    private PaginationHelper<Integer> helperTest2;
    private List<Integer> collection;
    private int itemsPerPage;
    private int pageItemCountInput;
    private int expectedPageItemCount;
    private int itemIndexInput;
    private int expectedItemIndex;


    public FurtherPaginationHelperTests(List<Integer> collection, int itemsPerPage, int pageItemCountInput, int expectedPageItemCount, int itemIndexInput, int expectedItemIndex) {
        this.collection = collection;
        this.itemsPerPage = itemsPerPage;
        this.pageItemCountInput = pageItemCountInput;
        this.expectedPageItemCount = expectedPageItemCount;
        this.itemIndexInput = itemIndexInput;
        this.expectedItemIndex = expectedItemIndex;
    }

    @Before
    public void setup() {
        this.helperTest2 = new PaginationHelper <>(this.collection, this.itemsPerPage);


    }

    @Parameterized.Parameters
    public static Collection <Object> testConditions (){
        return Arrays.asList(new Object[][]{

                {Arrays.asList(1,2,3,4,5), 2, 2, 1, 1, 0},
                {Arrays.asList(1,2,3,4,5,6), 3, 2, -1, 5, 1},
                {Arrays.asList(1,2,3,4,5,6,7,8), 4, 1, 4, 8, -1},
                {Arrays.asList(1,2,3,4,5,6,7,8,9), 5, 1, 4, 0, 0},
                {Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14), 6, 0, 6, 6, 1}

        });
    }

    @Test
    public void pageItemCount(){

        assertEquals(expectedPageItemCount, helperTest2.pageItemCount(pageItemCountInput));

    }

    @Test
    public void itemIndex (){

        assertEquals(expectedItemIndex, helperTest2.itemIndex(itemIndexInput));

    }



}
