package DataStructure;


import java.util.Arrays;
import java.util.Random;

public class SortingComparison {

    private static int comparisons = 0;
    private static int interchanges = 0;

    public static void main(String[] args) {
        int size = 10000;

        // Generate arrays
        int[] randomArray = new int[size];
        int[] sortedArray = new int[size];
        int[] inverselySortedArray = new int[size];

        generateRandomArray(size, randomArray);
        generateSortedArray(size, sortedArray);
        generateInverselySortedArray(size, inverselySortedArray);

        // Create a StringBuilder to store the table
        StringBuilder table = new StringBuilder();
        table.append(String.format("%-30s%-20s%-25s%-25s%-25s%n", "Algorithm", "Array Type", "Relative Run Time (ns)",
                "Number of Comparisons", "Number of Interchanges"));

        // Linear Sort
        testSortingAlgorithm(table, "Linear Sort - Random", Arrays.copyOf(randomArray, randomArray.length));
        testSortingAlgorithm(table, "Linear Sort - Sorted", Arrays.copyOf(sortedArray, sortedArray.length));
        testSortingAlgorithm(table, "Linear Sort - Inversely Sorted", Arrays.copyOf(inverselySortedArray, inverselySortedArray.length));

        // Bubble Sort
        testSortingAlgorithm(table, "Bubble Sort - Random", Arrays.copyOf(randomArray, randomArray.length));
        testSortingAlgorithm(table, "Bubble Sort - Sorted", Arrays.copyOf(sortedArray, sortedArray.length));
        testSortingAlgorithm(table, "Bubble Sort - Inversely Sorted", Arrays.copyOf(inverselySortedArray, inverselySortedArray.length));

        // Quick Sort
        testSortingAlgorithm(table, "Quick Sort - Random", Arrays.copyOf(randomArray, randomArray.length));
        testSortingAlgorithm(table, "Quick Sort - Sorted", Arrays.copyOf(sortedArray, sortedArray.length));
        testSortingAlgorithm(table, "Quick Sort - Inversely Sorted", Arrays.copyOf(inverselySortedArray, inverselySortedArray.length));

        // Print the table
        System.out.println(table.toString());
    }

    private static void testSortingAlgorithm(StringBuilder table, String algorithm, int[] array) {
        resetCounters();
        long startTime = System.nanoTime();

        switch (algorithm.split(" ")[0]) {
            case "Linear":
                linearSort(array);
                break;
            case "Bubble":
                bubbleSort(array);
                break;
            case "Quick":
                quickSort(array, 0, array.length - 1);
                break;
        }

        long endTime = System.nanoTime();
        long runTime = endTime - startTime;

        // Append the results to the table
        table.append(String.format("%-30s%-20s%-25d%-25d%-25d%n", algorithm, getArrayType(algorithm),
                runTime, getComparisons(), getInterchanges()));
    }

    private static String getArrayType(String algorithm) {
        return algorithm.contains("Random") ? "Random"
                : algorithm.contains("Sorted") ? "Sorted"
                        : algorithm.contains("Inversely Sorted") ? "Inversely Sorted" : "";
    }

    private static void generateRandomArray(int size, int[] array) {
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000); // Adjust the bound based on your requirements
        }
    }

    private static void generateSortedArray(int size, int[] array) {
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
    }

    private static void generateInverselySortedArray(int size, int[] array) {
        for (int i = 0; i < size; i++) {
            array[i] = size - i;
        }
    }

public static void linearSort(int[] inputArray) {
    int N = inputArray.length;
    int M = 0;
    boolean isAlreadySorted = true;

    for (int i = 0; i < N; i++) {
        M = Math.max(M, inputArray[i]);
        if (i > 0 && inputArray[i - 1] > inputArray[i]) {
            isAlreadySorted = false;
        }
    }

    int[] countArray = new int[M + 1];

    if (!isAlreadySorted) {
        for (int i = 0; i < N; i++) {
            countArray[inputArray[i]]++;
        }

        int outputIndex = 0;
        for (int i = 0; i <= M; i++) {
            while (countArray[i] > 0) {
                if (inputArray[outputIndex] != i) {
                    interchanges++;
                }
                inputArray[outputIndex++] = i;
                comparisons++; 
                countArray[i]--;
            }
        }
    }

    comparisons = isAlreadySorted ? N - 1 : comparisons;
}







    private static void bubbleSort(int[] array) {
        // Implement Bubble Sort logic
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < array.length; i++) {
                comparisons++;
                if (array[i - 1] > array[i]) {
                    swap(array, i - 1, i);
                    interchanges++;
                    swapped = true;
                }
            }
        } while (swapped);
    }

private static void quickSort(int[] array, int low, int high) {
    // Implement Quick Sort logic
    if (low < high) {
        int partitionIndex = partition(array, low, high);

        quickSort(array, low, partitionIndex - 1);
        quickSort(array, partitionIndex + 1, high);
    }
}

private static int partition(int[] array, int low, int high) {
    int pivot = array[high];
    int i = low - 1;

    for (int j = low; j < high; j++) {
        comparisons++;
        if (array[j] < pivot) {
            i++;
            swap(array, i, j);
            interchanges++;
        }
    }

    // Only swap if there are elements smaller than the pivot
    if (array[high] < array[i + 1]) {
        swap(array, i + 1, high);
        interchanges++;
    }

    return i + 1;
}


    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void resetCounters() {
        comparisons = 0;
        interchanges = 0;
    }

    private static int getComparisons() {
        return comparisons;
    }

    private static int getInterchanges() {
        return interchanges;
    }
}





