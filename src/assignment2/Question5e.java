package assignment2;

import java.util.Scanner;

public class Question5e {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of symmetric matrix: ");
        int MAX = sc.nextInt();

        int[] arr = new int[(MAX * (MAX + 1)) / 2];

        System.out.println("Enter the upper triangular elements row-wise (including diagonal):");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int[][] symmetricArray = new int[MAX][MAX];
        int k = 0;

        // fill upper triangular and diagonal
        for (int i = 0; i < MAX; i++) {
            for (int j = i; j < MAX; j++) {
                symmetricArray[i][j] = arr[k];
                symmetricArray[j][i] = arr[k]; // mirror to lower triangle
                k++;
            }
        }

        // printing
        System.out.println("Symmetric matrix:");
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                System.out.print(symmetricArray[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
