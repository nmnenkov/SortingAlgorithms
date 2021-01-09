package sortingalgorithms;

import com.nenkov.main.Utilities.Util;
import java.util.Arrays;

/**
 *
 * @author Nenkov
 */
public final class BubbleSort {

    public static int[] sortArray(int[] sortArray, boolean printDetails) {
        // used to count the steps and the swaps
        int countSteps = 0, countSwaps = 0;
        // used for optimization - in each cycle ti is redused with one as the max value element is already at the end of the array
        int index2 = sortArray.length - 1;
        // used to check if swap was done during the cycle
        boolean swapDone;

        if (printDetails) {
            System.out.println("Start BubbleSort array is: " + Util.printArray(sortArray));
            ;
        }

        do {
            //Set this to false at the beginning of each loop through the array
            swapDone = false;
            for (int index1 = 0; index1 < index2; index1++) {
                countSteps++;
                if (printDetails) {
                    System.out.println("Step - " + countSteps + " index1 = " + index1);
                }
                // if array element at index X is bigger than the element at index X+1 swap the values of these 2 indexes
                // this is exactly the bubble:
                // (arr[x], arr[x+1])
                if (sortArray[index1] > sortArray[index1 + 1]) {
                    swapDone = true;
                    if (printDetails) {
                        System.out.println("Swap - " + countSwaps + " swap indexes " + index1 + " and " + (index1 + 1));
                        System.out.println(Util.printArrayWithBubble(sortArray, index1));
                        
                    }
                    countSwaps++;
                    int tmpElementValue = sortArray[index1];
                    sortArray[index1] = sortArray[index1 + 1];
                    sortArray[index1 + 1] = tmpElementValue;

                    if (printDetails) {
                        System.out.println(Util.printArrayWithBubble(sortArray, index1));
                    }
                }
            }
            index2--;
            // Loop until there are no array elements swap
        } while (swapDone);
        System.out.printf("Array was sorted in %d steps and %d swaps\n", countSteps, countSwaps);
        return sortArray;
    }

}
