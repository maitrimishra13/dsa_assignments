package assignment2;

import java.util.Scanner;

public class Question5a {
    /*
    Diagonal matrix
    * */
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array");
        int MAX = sc.nextInt();

        //creating the array
        int[] arr = new int[MAX];

        //scanning the array
        System.out.println("Enter the elements in the array");
        for(int i = 0; i < MAX; i++){
            arr[i] = sc.nextInt();
        }

        //printing
        int size = MAX;
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                if(i == j){
                    System.out.print(" " + arr[i] + " ");
                }
                else{
                    System.out.print(" 0 ");
                }
            }
            System.out.println();
        }

        sc.close();
    }
}
