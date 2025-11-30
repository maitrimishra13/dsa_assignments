package assignment7;

import java.util.Scanner;

public class Question2 {
    /*
    A slightly improved selection sort –
    We know that selection sort algorithm takes the minimum on every pass on the array,
    and place it at its correct position.
    The idea is to take also the maximum on every pass and
    place it at its correct position.
    So in every pass, we keep track of both
    maximum and minimum and array becomes sorted from both ends.
    Implement this logic.
    */

    public static void main(String[] args) {

        System.out.print("Enter size: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = create(n, sc);

        System.out.println("Improvised Selection sort : ");
        improvisedSelectionSort(arr);
        print(arr);
        sc.close();
    }

    public static int[] create(int n, Scanner sc){   // ✅ use same scanner
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            System.out.print("Enter element "+ (i+1) + " : ");
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static void print(int[] arr){
        System.out.println("Sorted Array:");
        for(int x: arr){
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void improvisedSelectionSort(int[] arr){
        int left = 0;
        int right = arr.length - 1;

        while(left < right){
            int min = left;
            int max = left;

            // Find min and max in current range
            for(int i = left; i <= right; i++){
                if(arr[i] < arr[min]){
                    min = i;
                }
                if(arr[i] > arr[max]){
                    max = i;
                }
            }

            // Swap min with left
            int temp = arr[left];
            arr[left] = arr[min];
            arr[min] = temp;

            // If max was at left, after swap it's now at 'min'
            if(max == left){
                max = min;
            }

            // Swap max with right
            temp = arr[right];
            arr[right] = arr[max];
            arr[max] = temp;

            left++;
            right--;
        }
    }
}
