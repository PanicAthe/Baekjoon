import java.util.Arrays;

class Solution {
    public String solution(String my_string, int num1, int num2) {
        char[] arr = my_string.toCharArray();
        char temp = my_string.charAt(num1);
        arr[num1] = my_string.charAt(num2);
        arr[num2] = temp;
        return new String(arr);
    }
}