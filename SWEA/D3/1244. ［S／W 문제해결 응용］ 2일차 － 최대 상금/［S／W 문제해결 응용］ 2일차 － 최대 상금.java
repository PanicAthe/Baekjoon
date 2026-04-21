import java.util.*;
import java.io.FileInputStream;

public class Solution {
    static int result = 0;
    static Set<String> visited = new HashSet<>();

    public static void main(String[] args) throws Exception {
        // 아래 코드는 테스트를 위해 파일로부터 입력을 받을 때 사용합니다.
        // 제출 시 주석 처리해야 합니다.
        // System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int m = sc.nextInt(); // 교환 횟수

            result = 0;
            visited.clear(); // 상태 기록 초기화
            change(Integer.toString(n).toCharArray(), 0, m);
            System.out.println("#" + test_case + " " + result);
        }
    }

    public static void change(char[] s, int current, int max) {
        String currentState = new String(s);
        if (current == max) {
            result = Math.max(result, Integer.parseInt(currentState));
            return;
        }

        if (visited.contains(currentState + current)) {
            return; // 이미 방문한 상태는 건너뜀
        }

        visited.add(currentState + current);

        for (int i = 0; i < s.length; i++) {
            for (int j = i + 1; j < s.length; j++) {
                // Swap
                char temp = s[i];
                s[i] = s[j];
                s[j] = temp;

                // Recursive call
                change(s, current + 1, max);

                // Swap back (backtracking)
                temp = s[i];
                s[i] = s[j];
                s[j] = temp;
            }
        }
    }
}
