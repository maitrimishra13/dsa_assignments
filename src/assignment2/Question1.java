package assignment2;

import java.util.Scanner;

public class Question1 {
    /*
    Implement the binary search algorithm regarded as a
    fast search algorithm with run-time complexity of Ο(log n)
    in comparison to the Linear Search.
    */
    public static void main(String[] args) {
        System.out.print("Enter size: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = create(n, sc);
        sort(arr);

        int number;

        do {
            System.out.println("\n--MENU--");
            System.out.println("1. BINARY SEARCH");
            System.out.println("2. LINEAR SEARCH");
            System.out.println("3. EXIT");
            System.out.print("Enter a number: ");
            number = sc.nextInt();

            switch (number) {
                case 1 -> {
                    System.out.println("Enter the number to be found: ");
                    int x = sc.nextInt();
                    System.out.println("The index is : " + binarySearch(arr, x));
                }
                case 2 -> {
                    System.out.println("Enter the number to be found: ");
                    int x = sc.nextInt();
                    System.out.println("The index is : " + linearSearch(arr, x));
                }
                case 3 -> System.out.println("EXIT");
                default -> System.out.println("Choose a valid number.");
            }

        } while(number!=3);

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

    public static void sort(int[] arr){
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

    public static int binarySearch(int[] arr, int x){
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = left + (right-left)/2;

            if(arr[mid] == x){
                return mid;
            }

            if(arr[mid] < x){
                left = mid + 1;
            } else { right = mid - 1; }
        }
        return -1;
    }

    public static int linearSearch(int[] arr, int x){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            if(arr[i] == x){
                return i;
            }
        }
        return -1;
    }
}
