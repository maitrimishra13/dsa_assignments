package assignment2;

import java.util.Scanner;

public class Question5b {
    /*
    Tridiagonal Matrix
     */
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of rows or columns in the tridiagonal array");
        int MAX = sc.nextInt();

        //creating the array
        int[] arr = new int[(3*MAX - 2)];

        //scanning the array
        System.out.println("Enter the elements in the array");
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }

        int k = 0;
        // printing tridiagonal matrix
        for (int i = 0; i < MAX; i++){
            for (int j = 0; j < MAX; j++){

                if (i == j || i == j + 1 || j == i + 1) {
                    System.out.print(arr[k] + " ");
                    k++;
                }
                else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }

        sc.close();
    }
}

