import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        boolean[] dp = new boolean[N + 1];

        dp[0] = false; 
        for (int i = 1; i <= N; i++) {
            if (i - 1 >= 0 && !dp[i - 1]) dp[i] = true;
            else if (i - 3 >= 0 && !dp[i - 3]) dp[i] = true;
            else if (i - 4 >= 0 && !dp[i - 4]) dp[i] = true;
        }

        if (dp[N]) System.out.println("SK");
        else System.out.println("CY");
    }
}