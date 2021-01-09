/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nenkov.main;

import com.nenkov.main.Utilities.Util;
import java.util.Arrays;
import sortingalgorithms.BubbleSort;
import sortingalgorithms.QuickSort;

/**
 *
 * @author nik
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Start Sorting Algorithms demo");
        int[] sortArrey = Util.generateRandomArray(30, 0, 30);
        //int[] sortArrey = {0,1,2,3,4,5,6,7,8,9,10};
        //Bubble  Sort - START
        System.out.println("Bubble Sort Start");
        System.out.println("Input Array: " + Arrays.toString(sortArrey));
        long sortStartTime = System.nanoTime();
        int[] SortedArray = BubbleSort.sortArray(Arrays.copyOf(sortArrey, sortArrey.length), false);
        long sortUsedTime = System.nanoTime()-sortStartTime;
        System.out.println("Used time in nanoseconds: "+sortUsedTime+" Sorted Array: " + Arrays.toString(SortedArray)+"\n");
        
        //Bubble  Sort - END

        //QuickSort - START
        System.out.println("QuickSort Start");
        System.out.println("Input Array: " + Arrays.toString(sortArrey));
        // Pivot Random
        System.out.println("Start Random pivot");
        QuickSort quickSortRandomPivot = new QuickSort(Arrays.copyOf(sortArrey, sortArrey.length), QuickSort.PivotPosition.RANDOM, false);
        sortStartTime = System.nanoTime();
        quickSortRandomPivot.quickSort(0, quickSortRandomPivot.arr.length-1);
        sortUsedTime = System.nanoTime()-sortStartTime;
        System.out.println("Sorted in "+quickSortRandomPivot.getCountSteps()+" steps and "+ quickSortRandomPivot.getCountSwaps()+" swaps Used time in nanoseconds: " + sortUsedTime +" Array: " + Arrays.toString(quickSortRandomPivot.arr) );
        
        // Pivot Middle
        System.out.println("Start Middle pivot");
        QuickSort quickSortMiddlePivot = new QuickSort(Arrays.copyOf(sortArrey, sortArrey.length), QuickSort.PivotPosition.MIDDLE, false);
        sortStartTime = System.nanoTime();
        quickSortMiddlePivot.quickSort(0, quickSortMiddlePivot.arr.length-1);
        sortUsedTime = System.nanoTime()-sortStartTime;
        System.out.println("Sorted in "+quickSortMiddlePivot.getCountSteps()+" steps "+ quickSortMiddlePivot.getCountSwaps()+" swaps Used time in nanoseconds: " + sortUsedTime +" Array: " + Arrays.toString(quickSortMiddlePivot.arr) );
        
        // Pivot Right
        System.out.println("Start Right pivot");
        QuickSort quickSortRightPivot = new QuickSort(Arrays.copyOf(sortArrey, sortArrey.length), QuickSort.PivotPosition.RIGHT, false);
        sortStartTime = System.nanoTime();
        quickSortRightPivot.quickSort(0, quickSortRightPivot.arr.length-1);
        sortUsedTime = System.nanoTime()-sortStartTime;
        System.out.println("Sorted in "+quickSortRightPivot.getCountSteps()+" steps and "+ quickSortRightPivot.getCountSwaps()+" swaps Used time in nanoseconds " + sortUsedTime +" Array: " + Arrays.toString(quickSortRightPivot.getArr()));
        //QuickSort - END
    }

}
