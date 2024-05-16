package DataStructure;

import java.util.Arrays;

public class BubbleSort {
    private int stepsN = 0;
    private int numInterchanges = 0;
    private int[] sortedArray;

    public BubbleSort(int array[]) {
        sort(array);
    }

    private void sort(int array[]) {
        sortedArray = Arrays.copyOf(array, array.length);
        for (int i = 0; i < sortedArray.length - 1; i++) {
            for (int j = 0; j < sortedArray.length - i - 1; j++) {
                if (sortedArray[j] > sortedArray[j + 1]) {
                    int temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j + 1];
                    sortedArray[j + 1] = temp;
                    stepsN++;
                    numInterchanges++;
                }
            }
        }
    }

    @Override
    public String toString() {
        //"BubbleSort:\nSorted Array: " + Arrays.toString(sortedArray) +
        return 
               "\nNumber of steps: " + stepsN +
               "\nNumber of interchanges: " + numInterchanges;
    }
}
