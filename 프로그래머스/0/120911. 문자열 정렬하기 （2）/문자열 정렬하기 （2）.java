import java.util.Arrays;

class Solution {
    public String solution(String my_string) {
        char[] chars =  my_string.toLowerCase().toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}