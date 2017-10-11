package edu.grinnell.sortingvisualizer.sorts;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortTest {

    // Test for Selection Sort
    @Test
    public void selectionSortTest2() {
        // first case
        Integer[] arr1 = { 7, 4, 5, 2, 1, 3, 8, 6 };
        Integer[] arr2 = { 1, 2, 3, 4, 5, 6, 7, 8 };
        Sort.selectionSort(arr1);
        assertArrayEquals(arr1, arr2);

        // second case: if the array contains no element
        Integer[] arr3 = {};
        Integer[] arr4 = {};
        Sort.selectionSort(arr3);
        assertArrayEquals(arr3, arr4);

        // third case: if the array contains only 1 element
        Integer[] arr5 = { 6 };
        Integer[] arr6 = { 6 };
        Sort.selectionSort(arr5);
        assertArrayEquals(arr5, arr6);

        // fourth case: if the array is already sorted
        Integer[] arr7 = { 1, 2, 3, 4, 5, 6, 7, 8 };
        Integer[] arr8 = { 1, 2, 3, 4, 5, 6, 7, 8 };
        Sort.selectionSort(arr7);
        assertArrayEquals(arr7, arr8);

        // fifth case: if the array is completely reversed
        Integer[] arr9 = { 1, 2, 3, 4, 5, 6, 7, 8 };
        Integer[] arr10 = { 1, 2, 3, 4, 5, 6, 7, 8 };
        Sort.selectionSort(arr9);
        assertArrayEquals(arr9, arr10);

    }


    //Test for Insertion Sort	

    //Test for Merge Sort


    //Test for bubble Sort

    //Test for Quick Sort



}
