package assignment2;

import java.util.Scanner;

public class Question5d {
    /*
    Upper triangular Matrix
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows or columns in the upper triangular array: ");
        int MAX = sc.nextInt();

        //creating the array
        int[] arr = new int[(MAX*(MAX+1))/2];

        //scanning the array
        System.out.println("Enter the elements of the array: ");
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }

        int k = 0;

        //printing the array
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                if(i<=j){
                    System.out.print(arr[k] + " ");
                    k++;
                }
                else{
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }

        sc.close();
    }
}

