import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] t = new int[n+1]; //상담에 걸리는 기간
        int[] p = new int[n+1]; //상담 별 금액
        int[] result = new int[n+2];
        for (int i = 1; i <= n; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            result[i] = Math.max(result[i], result[i - 1]);
            if (i + t[i] <= n + 1) {
                result[i + t[i]] = Math.max(result[i + t[i]], result[i] + p[i]);
            }
        }
        result[n + 1] = Math.max(result[n + 1], result[n]); // 마지막날도 반영

        int max = 0;
        for (int i = 1; i <= n + 1; i++) {
            max = Math.max(max, result[i]);
        }
        System.out.println(max);

    }
}
