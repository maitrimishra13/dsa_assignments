package assignment2;

import java.util.Scanner;

public class Question2 {
    /*
    Bubble Sort is the simplest sorting algorithm that works by
    repeatedly swapping the adjacent elements if they are in the wrong order.
    Code the Bubble sort with the following elements:
    [64 | 34 | 25 | 12 | 22 | 11 | 90]
    */
    public static void main(String[] args) {
        System.out.print("Enter size: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = create(n, sc);

        bubbleSort(arr);

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

    public static void bubbleSort(int[] arr){
        int n = arr.length - 1;
        boolean swapped;
        for(int i = 0; i < n; i++){
            swapped = false;
            for(int j = 0; j < n - i - 1; j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) break;
        }
    }

    public static void print(int[] arr){
        System.out.print("Sorted Array: ");
        for(int x : arr){
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
