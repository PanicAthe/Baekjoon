import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[k];
        Arrays.fill(answer, -1);
        boolean visited[] = new boolean[100001];
        int j=0;
        for(int i=0; i<arr.length;i++){
            if(!visited[arr[i]]&&j<k){
                answer[j++] = arr[i];
                visited[arr[i]] = true;
            }
        }
        return answer;
    }
}