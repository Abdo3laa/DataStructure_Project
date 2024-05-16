package DataStructure;

import java.util.Arrays;

public class CountingSort {

    private int[] array;
    private int stepsN;
    private int numInterchanges;

    public CountingSort(int[] array) {
        this.array = Arrays.copyOf(array, array.length);
        this.stepsN = 0;
        this.numInterchanges = 0;
        countingSort();
    }

    public void countingSort() {
        int n = array.length;

        // Find the maximum value in the array
        int max = Arrays.stream(array).max().orElse(0);

        // Create a count array to store the frequency of each element
        int[] count = new int[max + 1];

        // Count the occurrences of each element in the original array
        for (int i = 0; i < n; i++) {
            count[array[i]]++;
            stepsN++;
        }

        // Reconstruct the sorted array based on the count array
        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (count[i] > 0) {
                array[index++] = i;
                count[i]--;
                stepsN++;
                numInterchanges++;
            }
        }
    }

    @Override
    public String toString() {
        //"CountingSort:\nSorted Array: " + Arrays.toString(array) + 
        return 
               "\nNumber of steps: " + stepsN +
               "\nNumber of interchanges: " + numInterchanges + "\n";
    }
}