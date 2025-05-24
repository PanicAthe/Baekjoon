import java.util.HashMap;
import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {

            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int count = 0; //전치 횟수
            for (int i = n - 1; i > 0; i--) {
                if (arr[i][0] != i * n + 1) {
                    //전치해야함
                    if (count % 2 == 0) { //전치 안한 상태.
                        count++;
                    }
                } else {
                    //전치하지 말아야함
                    if (count % 2 == 1) {
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }
}