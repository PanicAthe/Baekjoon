import java.util.Arrays;

class Solution {
    public int solution(String before, String after){
        char[] arr1 = before.toCharArray();
        char[] arr2 = after.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i]) return 0;
        }
        return 1;
    }
}