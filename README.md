# Sorting Algorithms Comparison

## Overview
This Java program compares the performance of three sorting algorithms: Linear Sort, Bubble Sort, and Quick Sort. The comparison is based on execution time, number of comparisons, and number of interchanges across different types of arrays.

## Components

### Data Generation
The program generates three types of arrays:
- **Random Array:** Contains random integers.
- **Sorted Array:** Contains integers sorted in ascending order.
- **Inversely Sorted Array:** Contains integers sorted in descending order.

### Data Preprocessing
- **Generate Arrays:** Methods to populate arrays with random, sorted, and inversely sorted data.
- **Initialize Counters:** Variables to track the number of comparisons and interchanges during sorting.

### Sorting Algorithms
- **Linear Sort:** An implementation of a counting sort algorithm that handles arrays efficiently if elements are in a specific range.
- **Bubble Sort:** A simple comparison-based algorithm that repeatedly steps through the list, compares adjacent elements, and swaps them if necessary.
- **Quick Sort:** A comparison-based sorting algorithm that uses divide-and-conquer techniques to sort arrays efficiently.

### Algorithm Testing
- **Method:** `testSortingAlgorithm` runs each sorting algorithm on all three types of arrays and measures execution time, number of comparisons, and number of interchanges.
- **Results:** Results are stored and formatted into a table that shows the performance metrics for each sorting algorithm across different array types.

### Helper Methods
- **`generateRandomArray`**: Populates an array with random integers.
- **`generateSortedArray`**: Populates an array with integers sorted in ascending order.
- **`generateInverselySortedArray`**: Populates an array with integers sorted in descending order.
- **`linearSort`**: Implements the Linear Sort algorithm and tracks comparisons and interchanges.
- **`bubbleSort`**: Implements the Bubble Sort algorithm and tracks comparisons and interchanges.
- **`quickSort`**: Implements the Quick Sort algorithm and tracks comparisons and interchanges.
- **`partition`**: Supports Quick Sort by partitioning the array.
- **`swap`**: Swaps elements in an array.
- **`resetCounters`**: Resets comparison and interchange counters before each sort.
- **`getComparisons`** and **`getInterchanges`**: Return the current counts of comparisons and interchanges.

## Output
The program outputs a formatted table displaying:
- **Algorithm**: The sorting algorithm used.
- **Array Type**: Type of array being sorted.
- **Relative Run Time**: Time taken to sort the array in nanoseconds.
- **Number of Comparisons**: Total comparisons made during sorting.
- **Number of Interchanges**: Total interchanges made during sorting.

This structured approach provides a comprehensive analysis of sorting algorithms' performance and efficiency.
