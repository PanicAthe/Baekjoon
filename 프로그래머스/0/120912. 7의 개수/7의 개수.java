class Solution {
    public int solution(int[] array) {
        int answer = 0;
        for(int i=0; i<array.length;i++){
            int temp = array[i];
            while(temp>9){
                if(temp%10==7){
                    answer++;
                }
                temp/=10;
            }
            if(temp==7)
                answer++;
        }
        return answer;
    }
}