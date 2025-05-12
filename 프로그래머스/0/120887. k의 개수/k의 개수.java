class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        for(int l=i; l<=j;l++){
            for(char c : String.valueOf(l).toCharArray()){
                if(c-'0'==k){
                    answer++;
                }
            }
        }
        return answer;
    }
}