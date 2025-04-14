import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] submitted = new boolean[31]; // 인덱스 1~30 사용

        // 28명 입력 받기
        for (int i = 0; i < 28; i++) {
            int num = sc.nextInt();
            submitted[num] = true;
        }

        // 과제 안 낸 사람 출력
        for (int i = 1; i <= 30; i++) {
            if (!submitted[i]) {
                System.out.println(i);
            }
        }

        sc.close();
    }
}
