package com.martinmcclenaghan;

import java.util.List;

public class PaginationHelper<I> {

    private List<I> collection;
    private int itemsPerPage;


    public PaginationHelper(List<I> collection, int itemsPerPage) {

        this.collection = collection;
        this.itemsPerPage = itemsPerPage;

    }

    public int itemCount() {

        int count = 0;
        for (int i = 1; i <= collection.size(); i++) {

            count++;
        }

        return count;
    }

    public int pageCount(){

        //number of pages starts at 1 however the first page will bear the number zero as is zero-indexed

        int total = itemCount();
        int pages = -1;

        if(total % itemsPerPage == 0){

            pages = total / itemsPerPage;

        } else if(total < itemsPerPage && total > 0){

            pages = 1;

        } else if((total > itemsPerPage) && (total % itemsPerPage != 0)){

            pages = (total / itemsPerPage)+ 1;

        }

        return pages;

    }

    public int pageItemCount (int pageIndex){

        //page index is zero based
        //returns number of items on the current page

        int pagesZeroIndex = pageCount() - 1;

        if(pageIndex > pagesZeroIndex){
            return -1;
        } else if (pageIndex < pagesZeroIndex){
            return itemsPerPage;
        } else {

            int fullPages = itemCount()/itemsPerPage;
            return itemCount() - (fullPages*itemsPerPage);
        }
    }

    public int itemIndex (int itemIndex){

        //item index is zero pages and method returns page number on which that item can be found

        int currentPage =  itemIndex / itemsPerPage;

        if(itemIndex < 0 || itemIndex+1 > itemCount()){

            return -1;
        } else{

            return currentPage;
        }


    }

    public void printList (){

        for (int i = 0; i < collection.size(); i++){

            System.out.print(collection.get(i) + " ");

        }

        System.out.printf("%n");
    }
}
