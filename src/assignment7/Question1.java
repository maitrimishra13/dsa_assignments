package assignment7;

import java.util.Scanner;

public class Question1 {

    public static void main(String[] args) {
        int number;

        System.out.print("Enter array size: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print("Enter array elements: ");
        int[] arr = create(n, sc);  // ✅ pass scanner instead of creating new one

        do {
            System.out.println("\n--MENU--");
            System.out.println("1. SELECTION SORT");
            System.out.println("2. INSERTION SORT");
            System.out.println("3. BUBBLE SORT");
            System.out.println("4. MERGE SORT");
            System.out.println("5. QUICK SORT");
            System.out.println("6. EXIT");
            System.out.print("Enter a number: ");
            number = sc.nextInt();

            switch (number) {
                case 1 -> {
                    selectionSort(arr);
                    print(arr);
                }
                case 2 -> {
                    insertionSort(arr);
                    print(arr);
                }
                case 3 -> {
                    bubbleSort(arr);
                    print(arr);
                }
                case 4 -> {
                    mergeSort(arr, 0, arr.length-1);
                    print(arr);   // ✅ moved print here
                }
                case 5 -> System.out.println("Quick sort not implemented yet.");
                case 6 -> System.out.println("EXIT");
                default -> System.out.println("Choose a valid number.");
            }

        } while(number!=6);

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

    public static void selectionSort(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n-1; i++){
            int min = i;
            for(int j = i+1; j < n; j++){
                if(arr[min] > arr[j]){
                    min = j;
                }
            }
            if(min!=i){
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
    }

    public static void insertionSort(int[] arr){
        int n = arr.length;
        for(int i = 1; i < n; i++){
            int key = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > key){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void bubbleSort(int[] arr){
        int n = arr.length;
        boolean flag;
        for(int i = 0; i < n - 1; i++){
            flag = false;
            for(int j = 0; j < n - i - 1; j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if(!flag) break;
        }
    }

    public static void mergeSort(int[] arr, int left, int right){
        if(left < right){
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right){
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for(int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for(int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while(i < n1 && j < n2){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while(i < n1){
            arr[k] = L[i];
            i++; k++;
        }
        while(j < n2){
            arr[k] = R[j];
            j++; k++;
        }
    }
}
