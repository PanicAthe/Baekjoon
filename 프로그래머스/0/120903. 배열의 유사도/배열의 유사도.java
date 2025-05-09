import java.util.Arrays;

class Solution {
    public int solution(String[] s1, String[] s2) {
        Arrays.sort(s1);
        Arrays.sort(s2);
        int result = 0;
        int s1_index = 0;
        int s2_index = 0;
        while(s1_index < s1.length && s2_index < s2.length) {
            if(s1[s1_index].equals(s2[s2_index])) {
                result++;
                s1_index++;
                s2_index++;
            }else if(s1[s1_index].compareTo(s2[s2_index]) > 0) {
                s2_index++;
            }else if(s1[s1_index].compareTo(s2[s2_index]) < 0) {
                s1_index++;
            }
        }
        return result;
    }
}