/**
 * Задача "Пирамида"
 * 
 * На вход программы подается количество чисел и сами числа.
 * На выход подается количество уровней пирамиды.
 * 
 * 
 */
package pyramid;

import java.util.Scanner;

public class Pyramid {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] arr = new int[count];
        for(int i = 0; i < count; i++){
            arr[i] = scanner.nextInt();
        }
        doSort(0, arr.length-1, arr);
        int answ = 0;
        
        for(int i = 0; i < count; i++){
            if(i < count-2 && arr[i] == arr[i+2]){
                arr[i]++;
                answ++;
                continue;
            }
            if(i < count-1 && arr[i] == arr[i+1]){
                answ++;
                continue;
            }
            if(i > 0 && arr[i] == arr[i-1]){
                if(i == count-1 || arr[i]-1 > arr[i+1]){
                    arr[i]--;
                    answ++;
                    continue;
                }
            }
            if(i == 0 || arr[i]+1 == arr[i-1]){
                answ++;
            }
        }
        
        System.out.println("answ = " + answ);
    }
    
    public static void doSort(int start, int end, int[] array){
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (array[i] >= array[cur])) {
                i++;
            }
            while (j > cur && (array[cur] >= array[j])) {
                j--;
            }
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        doSort(start, cur, array);
        doSort(cur+1, end, array);
    }
    
}
