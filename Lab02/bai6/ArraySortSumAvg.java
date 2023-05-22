package bai6;

import java.util.Arrays;
import java.util.Scanner;

public class ArraySortSumAvg {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];

        System.out.println("Enter the array elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr); // sort the array

        System.out.println("Sorted array: " + Arrays.toString(arr));

        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += arr[i]; // calculate the sum of array elements
        }

        double average = (double) sum / size; // calculate the average value of array elements

        System.out.println("Sum of array elements: " + sum);
        System.out.println("Average value of array elements: " + average);

        sc.close();
    }

}
