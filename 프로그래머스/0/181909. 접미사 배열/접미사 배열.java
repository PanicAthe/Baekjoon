import java.util.Arrays;

class Solution {
    public String[] solution(String my_string) {
        int len = my_string.length();
        String[] ans = new String[len];

        for (int i = 0; i < len; i++) {
            ans[i] = my_string.substring(i);
        }

        Arrays.sort(ans);
        return ans;
    }
}
