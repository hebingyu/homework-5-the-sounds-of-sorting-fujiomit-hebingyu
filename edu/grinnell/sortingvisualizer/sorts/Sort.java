package edu.grinnell.sortingvisualizer.sorts;

import java.util.LinkedList;
import java.util.List;

import edu.grinnell.sortingvisualizer.events.CompareEvent;
import edu.grinnell.sortingvisualizer.events.CopyEvent;
import edu.grinnell.sortingvisualizer.events.SortEvent;
import edu.grinnell.sortingvisualizer.events.SwapEvent;

public class Sort {

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static <T extends Comparable<T>> void 
    swap(T[] arr, int i, int j, LinkedList<SortEvent<T>> actlist) {
        actlist.add(new SwapEvent(i,j));
        T temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;		
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static <T extends Comparable<T>> LinkedList<SortEvent<T>> selectionSort(T[] arr) {
        LinkedList<SortEvent<T>> actlist = new LinkedList<SortEvent<T>>();

        int n = arr.length;
        for (int i = 0; i < n-1; i++){			
            int minIdn = i;
            for (int j = i+1; j < n; j++) {
                actlist.add(new CompareEvent(j, minIdn));
                if (arr[j].compareTo(arr[minIdn]) < 0) {
                    minIdn = j;
                }
            }
            // Swap the found minimum element with the first
            // element
            swap(arr, i, minIdn, actlist);
        }

        return actlist;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static <T extends Comparable<T>> LinkedList<SortEvent<T>> insertionSort(T[] arr) {
        LinkedList<SortEvent<T>> actlist = new LinkedList<SortEvent<T>>();

        for (int i=1; i< arr.length; i++) {
            for(int j=i; j > 0; j--) {
                actlist.add(new CompareEvent(j-1, j));
                if(arr[j - 1].compareTo(arr[j]) > 0) {
                    swap(arr, j-1, j, actlist);
                }
            }				
        }
        return actlist;
    }


    // pre: arr[l], ..., arr[m - 1] is sorted
    //      arr[m], ..., arr[l] is sorted
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static <T extends Comparable<T>> 
    void merge (T[] arr, int l, int m, int h, LinkedList<SortEvent<T>> actlist) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = h - m;

        /* Create temp arrays */
        Object[] L = new Integer[n1];
        Object[] R = new Integer[n2];


        //T[] L = (T[]) new Object [n1];
        //T[] R = (T[]) new Object [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i < n1; ++i) {
            actlist.add(new CopyEvent(i, arr[l+i]));
            L[i] = arr[l + i];
        }
        for (int j=0; j<n2; ++j) {
            actlist.add(new CopyEvent(j, arr[m+1+j]));
            R[j] = arr[m + 1+ j];
        }

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            actlist.add(new CompareEvent(i,j));
            if (((Comparable<T>) L[i]).compareTo((T) R[j]) <= 0) {
                actlist.add(new CopyEvent(k,L[i]));
                arr[k] = (T) L[i];
                i++;
            } else {
                actlist.add(new CopyEvent(k, R[j]));
                arr[k] = (T) R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            actlist.add(new CopyEvent(k, L[i]));
            arr[k] = (T) L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            actlist.add(new CopyEvent(k, R[j]));
            arr[k] = (T) R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    public static <T extends Comparable<T>>  
    LinkedList<SortEvent<T>> mergeSort(T[] arr, int l, int r) {

        LinkedList<SortEvent<T>> actlist = new LinkedList<SortEvent<T>>();

        if (l < r) {
            // Find the middle point
            int m = l+(r-l)/2;
            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr , m+1, r);

            // Merge the sorted halves
            merge(arr, l, m, r, actlist);
        }

        return actlist;
    }




    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static <T extends Comparable<T>> 
    void qsort(T arr[], int l, int h, LinkedList<SortEvent<T>> actlist){

        int i = l;
        int j = h;
        // calculate pivot number, I am taking pivot as middle index number
        int pind = l+(h-l)/2;
        T pivot = arr[pind];
        // Divide into two arrays
        while (i <= j) {

            actlist.add(new CompareEvent(i, pind));
            while (arr[i].compareTo(pivot) < 0) {
                actlist.add(new CompareEvent(i, pind));
                i++;
            }

            actlist.add(new CompareEvent(j, pind));
            while (arr[j].compareTo(pivot) > 0) {
                actlist.add(new CompareEvent(j, pind));
                j--;
            }

            if (i <= j) {
                swap(arr,i, j, actlist);
                //move index to next position on both sides
                i++;
                j--;
            }			
        }

        // call quickSort() method recursively
        if (l < j) {
            qsort(arr,l, j, actlist);
        }
        if (i < h) {
            qsort(arr,i, h, actlist);
        }
    }

    public static <T extends Comparable<T>> LinkedList<SortEvent<T>> 
    quickSort(T arr[], int l, int h){
        LinkedList<SortEvent<T>> actlist = new LinkedList<SortEvent<T>>();
        qsort(arr, 0, arr.length-1, actlist);
        return actlist;
    }



    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static <T extends Comparable<T>> LinkedList<SortEvent<T>> bubbleSort(T[] arr) {
        LinkedList<SortEvent<T>> actlist = new LinkedList<SortEvent<T>>();

        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-1-i; j++) {
                actlist.add(new CompareEvent(j, j+1));
                if (arr[j].compareTo(arr[j+1]) > 0) {
                    swap(arr, j, j+1,actlist);
                }
            }
        return actlist;
    }

    public static <T> void eventSort(T[] l, List<SortEvent<T>> events) {
        for (int i=0; i < l.length; i++) {
            events.get(i).apply(l);
        }
    }

}
