import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] result = new int[41][2];

        //0
        result[0][0] = 1;
        result[0][1] = 0;

        //1
        result[1][0] = 0;
        result[1][1] = 1;

        //2
        result[2][0] = 1;
        result[2][1] = 1;

        for (int i = 3; i < 41; i++) {
            result[i][0] = result[i - 1][0] + result[i - 2][0];
            result[i][1] = result[i - 1][1] + result[i - 2][1];
        }

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            System.out.println(result[x][0] + " " + result[x][1]);
        }


    }
}
