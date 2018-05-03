package invertedlinkedlist;

/**
* Переворот односвязного списка
*/

import java.util.Scanner;

public class InvertedLinkedList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int[] arr = new int[a+1];
        arr[0] = 1;
        for(int i = 1; i <= a; i++){
            arr[i] = scanner.nextInt();
        }
        int[] linkedList = new int[a];
        linkedList[0] = 1;
        for(int i = 1; i < a; i++){
            linkedList[i] = arr[linkedList[i-1]];
        }
        for(int i = a-1; i >= 0; i--){
            System.out.print(linkedList[i] + " ");
        }
    }
}
