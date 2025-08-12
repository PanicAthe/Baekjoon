import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int[] arr = new int[10];
        int setCount = 0;
        for(int i=0; i<input.length(); i++){
            int n = input.charAt(i) - '0';
            if(n==6||n==9){
                if(arr[6]>arr[9]){
                    arr[9]++;
                } else if(arr[6]== arr[9]){
                    arr[n]++;
                } else {
                    arr[6]++;
                }
            }else{
                arr[n]++;
            }
            
            if(arr[n] > setCount) {
                setCount = arr[n];
            }
        }
        System.out.println(setCount);
        sc.close();
    }
}
