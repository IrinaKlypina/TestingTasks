package formattingtable;
/**
 * Форматирование таблицы
 */
import java.util.Scanner;

public class FormattingTable {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = "";
        while(scanner.hasNextLine()){
            String ex = scanner.nextLine();
            if(ex.equals(""))break;
            s += ex + "\n";
        }
        String[] arr = s.split("\n");
        String[][] answ = new String[arr.length][(int)arr[0].chars().filter(ch -> ch == '|').count()-1];      
        int[] arrCounts = new int[(int)arr[0].chars().filter(ch -> ch == '|').count()-1];
        for(int i = 0; i<arr.length; i++){
            arr[i] = arr[i].substring(1, arr[i].length()-1);
            String[] arr1 = arr[i].split("\\|"); 
            for(int j = 0; j<arr1.length; j++){
                answ[i][j] = arr1[j].trim();
                if(arrCounts[j] < answ[i][j].length()){
                    arrCounts[j] = answ[i][j].length();
                }
            }
        }
        for(int i = 0; i<answ.length; i++){
            System.out.print("|");          
            for(int j = 0; j<answ[i].length; j++){
                System.out.print(repeat(" ", (arrCounts[j]-answ[i][j].length())/2) + answ[i][j] + repeat(" ", (arrCounts[j]-answ[i][j].length())%2 == 0 ? (arrCounts[j]-answ[i][j].length())/2 : (arrCounts[j]-answ[i][j].length())/2+1) + "|");                
            }
            System.out.println();
        }
    }
    
    public static String repeat(String s, int n){
        String answ = "";
        for(int i=0; i<n; i++){
            answ += s;
        }
        return answ;
    }
    
    
}
