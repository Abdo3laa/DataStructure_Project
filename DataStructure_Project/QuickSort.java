package DataStructure;

import java.util.Arrays;

public class QuickSort {
    private int stepsN = 0;
    private int numInterchanges = 0;
    private int[] sortedArray;

    public QuickSort(int array[]) {
        sort(array);
    }

    private void sort(int[] array) {
        sortedArray = Arrays.copyOf(array, array.length);
        quickSort(sortedArray, 0, sortedArray.length - 1);
    }

    private void quickSort(int[] array, int start, int end) {
        if (end <= start) return;

        int pivot = partition(array, start, end);
        quickSort(array, start, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    private int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int i = start - 1;

        for (int j = start; j <= end; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                stepsN++;
                numInterchanges++;
            }
        }

        i++;
        int temp = array[i];
        array[i] = array[end];
        array[end] = temp;

        return i;
    }

    @Override
    public String toString() {
        //"QuickSort:\nSorted Array: " + Arrays.toString(sortedArray) +
        return 
               "\nNum of steps: " + stepsN +
               "\nNum of interchanges: " + numInterchanges;
    }
}
