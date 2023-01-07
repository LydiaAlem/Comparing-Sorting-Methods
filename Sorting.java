/**
 * - Writing a Java Class to compare the different sorting algorithms.
 * - Using the nanoTime() the compare how long each algorithm takes.
 * - Implemented this using generic type T
 */

import java.util.*;

public class Sorting<T extends Comparable<T>>{
    T[] array;

    public Sorting(T[] array){
        this.array = array;
    }

    /**
     * Java's built-in sorting from the standard library {@java.util.Arrays}
     */

    public void javaSort(){
        Arrays.sort(this.array);
    }


    /**
     * Bubble-sort implementation
     * 
     * Time complexity -> O(n^2)
     * 
     * How it works: The algorithm repeatedly iterates through the array, 
     * comparing adjacent elements and swapping them if they are in the wrong order.
     * It repeats this process until the array is sorted.
     */

    public void bubbleSort(){
        for(int i = 0; i< this.array.length; i++){
            for(int j = 0 ; j < this.array.length - i - 1; j++){
                if(this.array[j].compareTo(this.array[j + 1]) > 0){
                    T temp = this.array[j];
                    this.array[j] = this.array[j + 1];
                    this.array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Insertion-sort implementation
     * 
     * Time complexity -> O(n^2)
     * 
     * How it works:  This algorithm sorts the array by 
     * iterating through it and inserting each element 
     * into its correct position in a sorted sub array.
     */

    public void insertionSort(){
        for(int i = 0; i< this.array.length; i++){
            T temp = this.array[i];
            int j = i - 1;
            while(j >= this.array.length){
                this.array[j + 1] = this.array[j];
                j--;
            }
            this.array[j + 1] = temp;
        }
    }

    /**
     * Quick-Sort Implementation 
     * 
     * Time complexity -> O(n log n)
     * 
     * How it works: his algorithm sorts the array by selecting a random "pivot" element 
     * and partitioning the array into two sub arrays: one containing elements less than 
     * the pivot, and one containing elements greater than the pivot. It then sorts 
     * the sub arrays recursively. It requires a helper method that grabs the random pivot point
     * and swaps. It also requires a helper method that divides the array by the pivot position.
     */
    public void quickSort(){
        quickSortHelper(this.array, 0, this.array.length - 1);
    }

    public void quickSortHelper(T[] array, int low, int high){
        if(low > high){
            return;
        }
        Random rand = new Random();
        int pivotIndex = rand.nextInt(high - low + 1) + low;
        T pivot = this.array[pivotIndex];

        // Swap the pivot element with the last element
        T temp = array[high];
        array[high] = pivot;
        array[pivotIndex] = temp;

        // Partition the array
        int partitionIndex = divide(array, low, high, pivot); //calling a helper method to divide the array by the pivot index

        // Sort the left and right halves
        quickSortHelper(array, low, partitionIndex - 1);
        quickSortHelper(array, partitionIndex + 1, high);
    }

    public int divide(T[] array, int low, int high, T pivot){
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) < 0) {
                i++;
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        T temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    /**
     * Heap-Sort implementation
     * 
     * Time complexity -> O(n log n)
     * 
     * How it works:  This algorithm sorts the array by building 
     * a heap data structure and repeatedly extracting the minimum
     * element from the heap. It requires a helper method that grabs 
     * the minimum element from the array and sorts the array
     */

    public void heapSort(){
        for (int i = this.array.length / 2 - 1; i >= 0; i--) {
            heapSortHelper(this.array, this.array.length, i);
        }
       
        for (int i = array.length - 1; i >= 0; i--) {  // Extract elements from the heap
            T temp = array[0]; // Move the current root (maximum element) to the end
            array[0] = array[i];
            array[i] = temp;

            heapSortHelper(array, i, 0); // Re-heap (hehe) the remaining elements
        }
    }

    public void heapSortHelper(T[] array, int heapSize, int rootIndex){
        int largest = rootIndex;
        int leftChildIndex = 2 * rootIndex + 1;
        int rightChildIndex = 2 * rootIndex + 2;

        // If the left child is larger than the root, set largest to the left child
        if (leftChildIndex < heapSize && this.array[leftChildIndex].compareTo(this.array[largest]) > 0) {   
        }

         // If the right child is larger than the largest so far, set largest to the right child
        if (rightChildIndex < heapSize && this.array[rightChildIndex].compareTo(this.array[largest]) > 0){
            largest = rightChildIndex;
        }

        // If the largest is not the root, swap the root with the largest and continue heaping (hehe)
        if (largest != rootIndex) {
            T temp = array[rootIndex];
            this.array[rootIndex] = this.array[largest];
            this.array[largest] = temp;
    
            heapSortHelper(this.array, heapSize, largest);
        }
    }
}
