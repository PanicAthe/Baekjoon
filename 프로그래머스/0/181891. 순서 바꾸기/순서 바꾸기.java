class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[num_list.length];      
        int j = 0;
        for(int i=n; i-n<num_list.length; i++){
            answer[j++] = num_list[i%num_list.length];
        }
        return answer;
    }
}