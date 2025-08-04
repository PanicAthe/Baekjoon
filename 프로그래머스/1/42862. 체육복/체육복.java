import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n + 2]; 
        Arrays.fill(students, 1);

        for (int l : lost) students[l]--; //도난
        for (int r : reserve) students[r]++; //여분

        for (int i = 1; i <= n; i++) {
            if (students[i] == 0) {
                if (students[i - 1] == 2) { //앞 사람 여분있음
                    students[i]++;
                    students[i - 1]--;
                } else if (students[i + 1] == 2) { //뒷 사람 여분있음
                    students[i]++;
                    students[i + 1]--;
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (students[i] >= 1) result++;
        }

        return result;
    }
}
