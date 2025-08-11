class Solution {
    public int solution(int num) {
        
        int answer = 0;
        long n = num;
        
        for(int i=0; i<500 && n != 1 ; i++){
            if(n%2==0){
                n/=2;
            }else{
                n*=3;
                n++;
            }
            answer++;
        }
        if(n==1){
            return answer;
        }
        return -1;
    }
}