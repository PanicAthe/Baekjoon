class Solution {
    public int solution(String my_string) {
        int answer = 0;
        int temp = 0;
        for(int i=0; i<my_string.length();i++){
            int n = my_string.charAt(i) - '0';
            if(n>=0&&n<10){
                temp = temp*10+n;
            }else{
                answer+=temp;
                temp = 0;
            }
        }
        answer+=temp;
        return answer;
    }
}