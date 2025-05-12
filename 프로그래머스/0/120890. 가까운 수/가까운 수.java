import java.util.*;
class Solution {
    public int solution(int[] array, int n) {
        int index = 0;
        Arrays.sort(array);
        for(int i=1; i<array.length;i++){
            if(Math.abs(n-array[i])<Math.abs(n-array[index])){
                index = i;
            }
        }
        return array[index];
    }
}