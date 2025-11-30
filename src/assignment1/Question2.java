package assignment1;

import java.util.Scanner;

public class Question2 {
    /*
    Design the logic to remove the duplicate elements from an Array
    and after the deletion the array should contain the unique elements.
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Question2 obj = new Question2();

        System.out.print("Enter size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            System.out.print("Enter element "+ (i+1) + " : ");
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                if(arr[i] == arr[j]) {
                    // shift elements to the left
                    for(int k = j; k < n - 1; k++) {
                        arr[k] = arr[k + 1];
                    }
                    n--;    // reduce size
                    j--;    // stay on same index
                }
            }
        }

        obj.display(arr, n);
        sc.close();
    }

    public void display(int[] arr, int n){
        System.out.print("Unique Array: ");
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
