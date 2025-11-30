package assignment1;

import java.util.Scanner;

public class Question1 {

    public static void main(String[] args){
        int number;

        int[] arr = null;

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\n--MENU--");
            System.out.println("1. CREATE");
            System.out.println("2. DISPLAY");
            System.out.println("3. INSERT");
            System.out.println("4. DELETE");
            System.out.println("5. LINEAR SEARCH");
            System.out.println("6. EXIT");
            System.out.print("Enter a number: ");
            number = sc.nextInt();

            switch (number) {
                case 1 -> {
                    System.out.print("Enter size: ");
                    int n = sc.nextInt();
                    arr = create(n, sc);
                }
                case 2 -> display(arr);
                case 3 -> {
                    if(arr != null){
                        System.out.print("Enter number to insert: ");
                        int num = sc.nextInt();
                        System.out.println("Position should be between " + 0 + " and " + arr.length);
                        System.out.print("Enter position: ");
                        int pos = sc.nextInt();
                        arr = insert(arr, num, pos);
                    } else {
                        System.out.println("Array not created!");
                    }
                }
                case 4 -> {
                    if(arr != null){
                        System.out.println("Position should be between " + 0 + " and " + arr.length);
                        System.out.print("Enter index to delete: ");
                        int indx = sc.nextInt();
                        arr = delete(arr, indx);
                    } else {
                        System.out.println("Array not created!");
                    }
                }
                case 5 -> {
                    if(arr != null){
                        System.out.print("Enter number to search: ");
                        int x = sc.nextInt();
                        int result = linearSearch(arr, x);
                        if(result == -1) System.out.println("Not found!");
                        else System.out.println("Found at index: " + result);
                    } else {
                        System.out.println("Array not created!");
                    }
                }
                case 6 -> System.out.println("EXIT");
                default -> System.out.println("Choose a valid number.");
            }

        } while(number!=6);

        sc.close();
    }


    public static int[] create(int n, Scanner sc){
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            System.out.print("Enter element "+ (i+1) + " : ");
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static void display(int[] arr){
        if(arr == null){
            System.out.println("Array not created!");
            return;
        }
        System.out.print("Array: ");
        for(int value : arr){
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static int[] insert(int[] arr, int num, int pos){
        int[] newArr = new int[arr.length + 1];

        if (pos < 0 || pos > arr.length) {
            System.out.println("Invalid position!");
            return arr;
        }

        for (int i = 0; i < pos; i++){
            newArr[i] = arr[i];
        }

        newArr[pos] = num;

        for (int i = pos; i < arr.length; i++){
            newArr[i+1] = arr[i];
        }

        return newArr;
    }

    public static int[] delete(int[] arr, int indx){
        if (indx < 0 || indx >= arr.length) {
            System.out.println("Invalid index!");
            return arr;
        }

        int[] newArr = new int[arr.length - 1];

        for(int i = 0, j = 0; i < arr.length; i++){
            if(i != indx){
                newArr[j] = arr[i];
                j++;
            }
        }

        return newArr;
    }

    public static int linearSearch(int[] arr, int x){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == x){
                return i;
            }
        }
        return -1;
    }
}
