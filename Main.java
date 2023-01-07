/**
 * Calling the Sorting method() and creating an array of size 10,000 using random numbers
 */


import java.util.*;

public class Main<T>  {
    public static void main(String[] args){
      //Random generating an array of integers
    public static void main(String[] args){
        Random rand = new Random();
        int arrSize = 100000;

        Integer[] array = new Integer[arrSize];
        for (int i = 0; i < arrSize; i++) {
            array[i] = rand.nextInt();
        }

        Sorting<Integer> sorting = new Sorting<>(array);

      //Java's Built-in
        long startTime = System.nanoTime();
        sorting.javaSort();
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Java's built-in sort took " + duration + " nanoseconds.");
        
      //Bubble-sort
        startTime = System.nanoTime();
        sorting.bubbleSort();
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Bubble sort took " + duration + " nanoseconds.");

      //Insertion-sort
        startTime = System.nanoTime();
        sorting.insertionSort();
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Insertion sort took " + duration + " nanoseconds.");

      //Quick-sort
        startTime = System.nanoTime();
        sorting.quickSort();
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Quick sort took " + duration + " nanoseconds.");
    }
}

