class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int sum = 0;
        for(int i=x; i>0; ){
            sum += i % 10;
            i/=10;
        }
        if(x%sum!=0){
            answer = false;
        }
        return answer;
    }
}