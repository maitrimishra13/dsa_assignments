package assignment2;

import java.util.Scanner;

public class Question3 {

    /*
      Design the Logic to Find a Missing Number in a Sorted Array.
      Given an array of n-1 distinct integers in the range 1 to n,
      find the missing number.
        (a) Linear time
        (b) Using binary search
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of n (array will have n-1 elements): ");
        int n = sc.nextInt();

        int[] arr = new int[n - 1];
        System.out.println("Enter sorted array elements (1 to n with one missing): ");
        for (int i = 0; i < n - 1; i++) {
            arr[i] = sc.nextInt();
        }

        int choice;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Find Missing Number (Linear Search)");
            System.out.println("2. Find Missing Number (Binary Search)");
            System.out.println("3. EXIT");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch(choice) {
                case 1 -> {
                    int missing = findMissingLinear(arr);
                    System.out.println("Missing number = " + missing);
                }
                case 2 -> {
                    int missing = findMissingBinary(arr);
                    System.out.println("Missing number = " + missing);
                }
                case 3 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }

        } while(choice != 3);

        sc.close();
    }

    // ------------------------------
    // (a) Linear Time
    // ------------------------------
    public static int findMissingLinear(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }
        return arr.length + 1;  // missing last number
    }

    // ------------------------------
    // (b) Binary Search
    // ------------------------------
    public static int findMissingBinary(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == mid + 1) {
                low = mid + 1;       // missing number is on the right
            } else {
                high = mid - 1;      // missing number is on the left
            }
        }

        return low + 1;  // low ends at the missing index
    }
}
