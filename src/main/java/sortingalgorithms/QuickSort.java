package sortingalgorithms;

import com.nenkov.main.Utilities.Util;

/**
 *
 * @author Nenkov
 */
public class QuickSort {

    public int[] arr;
    public boolean printDetails;
    private int countSteps = 0, countSwaps = 0;
    private PivotPosition pivotPosition;

    public static enum PivotPosition {
        RANDOM, MIDDLE, RIGHT
    };

    public QuickSort(int[] arr, PivotPosition pivotPosition, boolean printDetails) {
        this.arr = arr;
        this.pivotPosition = pivotPosition;
        this.printDetails = printDetails;
    }

    public int getCountSteps() {
        return countSteps;
    }

    public int getCountSwaps() {
        return countSwaps;
    }
    
    

    public int[] getArr() {
        return arr;
    }

    public final void quickSort(int low, int high) {

        if (low < high) {
            if (printDetails) {
                System.out.println("\nquickSort Start step - " + countSteps + " low = " + low + " high = " + high + " " + Util.printArray(arr));
            }
            int pivot = 0;
            switch (pivotPosition) {
                case RANDOM:
                    pivot = partitionRandom(low, high);
                    break;
                case MIDDLE:
                    pivot = partitionMiddle(low, high);
                    break;
                case RIGHT:
                    pivot = partitionRight(low, high);
                    break;
                default:
                    System.err.println("No such pivot position...");
                    return;
            }
            quickSort(low, pivot - 1);
            quickSort(pivot + 1, high);
        }
    }

    // best performance is achieved when random pivot position is used
    private final int partitionRandom(int low, int high) {
        int pivotIndex = Util.genRandomInt(low, high);
        int pivot = arr[pivotIndex];
        int currentIndex = (low); // index of smaller element 

        if (printDetails) {
            System.out.println("\nStart partition partitionRandom low = " + low + ", high= " + high + ", pivot = " + pivot + " " + Util.printArray(arr));
        }

        while (currentIndex <= high) {
            countSteps++;

            if (printDetails) {
                System.out.println("pivot = " + pivot + ", pivotIndex = " + pivotIndex + ", [ currentIndex = " + currentIndex + " value = " + arr[currentIndex] + " ]");
            }

            if (currentIndex != pivotIndex && currentIndex < pivotIndex) {
                if (arr[currentIndex] > arr[pivotIndex]) {
                    if (currentIndex + 1 == pivotIndex) {
                        if (printDetails) {
                            System.out.format("Swap %d and %d\n", arr[currentIndex], arr[pivotIndex]);
                            System.out.println(Util.printArray(arr));
                        }
                        countSwaps++;
                        int tmpInt = arr[pivotIndex];
                        arr[pivotIndex] = arr[currentIndex];
                        arr[currentIndex] = tmpInt;
                        pivotIndex--;
                        currentIndex++;
                    } else {
                        if (printDetails) {
                            System.out.format("Swap %d and %d after that swap %d and %d\n", arr[currentIndex], arr[pivotIndex - 1], arr[pivotIndex - 1], arr[pivotIndex]);
                            System.out.println(Util.printArray(arr));
                        }
                        countSwaps++;
                        int tmpCurrent = arr[currentIndex];
                        arr[currentIndex] = arr[pivotIndex - 1];
                        arr[pivotIndex] = tmpCurrent;
                        arr[pivotIndex - 1] = pivot;
                        pivotIndex--;
                    }
                    if (printDetails) {
                        System.out.println(Util.printArray(arr));
                    }

                } else {
                    currentIndex++;
                }

            } else { //currentIndex > pivotIndex

                if (currentIndex != pivotIndex && arr[currentIndex] <= arr[pivotIndex]) {
                    if (currentIndex - 1 == pivotIndex) {
                        if (printDetails) {
                            System.out.format("Swap %d and %d\n", arr[pivotIndex], arr[currentIndex]);
                            System.out.println(Util.printArray(arr));
                        }
                        countSwaps++;
                        int tmpInt = arr[pivotIndex];
                        arr[pivotIndex] = arr[currentIndex];
                        arr[currentIndex] = tmpInt;
                        pivotIndex++;
                        currentIndex++;
                    } else {
                        if (printDetails) {
                            System.out.format("Swap %d and %d after that swap %d and %d\n", arr[currentIndex], arr[pivotIndex + 1], arr[pivotIndex + 1], arr[pivotIndex]);
                            System.out.println(Util.printArray(arr));
                        }
                        countSwaps++;
                        int tmpCurrent = arr[currentIndex];
                        arr[currentIndex] = arr[pivotIndex + 1];
                        arr[pivotIndex] = tmpCurrent;
                        arr[pivotIndex + 1] = pivot;
                        pivotIndex++;
                    }

                    if (printDetails) {
                        System.out.println(Util.printArray(arr));
                    }

                } else {
                    currentIndex++;
                }
            }
        }

        if (printDetails) {
            System.out.println("End partition " + Util.printArray(arr));

        }

        return pivotIndex;
    }

    // When the pivot position is in the middle the worst scenario can be hit when the array is already ordered - O(n^2)
    private final int partitionMiddle(int low, int high) {
        int pivotIndex = (int) ((low + high) / 2);
        int pivot = arr[pivotIndex];
        int lowIndex = (low); // index of smaller element 
        int hightIndex = (high); // index of bigger element 

        if (printDetails) {
            System.out.println("\nStart partition partitionMiddle low = " + low + ", high= " + high + ", pivot = " + pivot + ", lowIndex = " + lowIndex + ", hightIndex = " + hightIndex);
        }

        while (lowIndex < hightIndex) {
            countSteps++;

            // the seccond condition after || is needed to handle the case when there are same number in the array
            while (arr[lowIndex] < pivot || (lowIndex != pivotIndex && pivot == arr[lowIndex])) {
                lowIndex++;
            }
            if (printDetails) {
                System.out.println("++lowIndex = " + lowIndex + ", lowIndex value " + arr[lowIndex] + ", pivotIndex = " + pivotIndex + ", pivot" + pivot);
            }
            // the seccond condition after || is needed to handle the case when there are same number in the array
            while (arr[hightIndex] > pivot || (hightIndex != pivotIndex && pivot == arr[hightIndex])) {
                hightIndex--;
            }
            if (printDetails) {
                System.out.println("--hightIndex = " + hightIndex + ", hightIndex value " + arr[hightIndex] + ", pivotIndex = " + pivotIndex + ", pivot = " + pivot);

            }

            if (printDetails) {
                System.out.println("pivot = " + pivot + " [ lowIndex = " + lowIndex + " value = " + arr[lowIndex] + " ][ hightIndex = " + hightIndex + " value = " + arr[hightIndex] + " ]");
            }

            if (lowIndex <= hightIndex && arr[lowIndex] > arr[hightIndex]) {
                if (printDetails) {
                    System.out.format("Swap %d and %d\n", arr[lowIndex], arr[hightIndex]);
                    System.out.println(Util.printArray(arr));
                }
                countSwaps++;
                int tmpInt = arr[lowIndex];
                arr[lowIndex] = arr[hightIndex];
                arr[hightIndex] = tmpInt;

                // this is needed in order to handle the case when there are same numbers in the array like {0,1,1,1,2,3...}
                if ((lowIndex == pivotIndex) || (hightIndex == pivotIndex)) {
                    if (lowIndex == pivotIndex) {
                        pivotIndex = hightIndex;
                    } else {
                        pivotIndex = lowIndex;
                    }
                }
            }

            if (printDetails) {
                System.out.println(Util.printArray(arr));
            }

        }

        if (printDetails) {
            System.out.println("End partition " + Util.printArray(arr));

        }

        return lowIndex;
    }

    //Common approach to use the last value as pivot
    private final int partitionRight(int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element 

        if (printDetails) {
            System.out.println("\nStart partition partitionRight low = " + low + ", high= " + high + ", pivot = " + pivot);
        }
        for (int j = low; j < high; j++) {
            countSteps++;
            // If current element is smaller than the pivot 
            if (arr[j] < pivot) {
                i++;

                if (i != j) {
                    if (printDetails) {
                        System.out.println("Swap elements i = " + i + " and j = " + j + " values " + arr[i] + " - " + arr[j]);
                        System.out.println(Util.printArray(arr));
                    }
                    countSwaps++;
                    // swap arr[i] and arr[j] 
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;

                    if (printDetails) {
                        System.out.println(Util.printArray(arr));
                    }

                }
            }
        }

        countSwaps++;
        // swap arr[i+1] and arr[high] (or pivot) 
        i++;
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;

        if (printDetails) {
            System.out.println("End partition " + Util.printArray(arr));
        }
        return i;

    }

}
