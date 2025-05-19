class Solution {
    public int solution(String my_string) {
        int answer = 0;
        for(int i=0; i<my_string.length();i++){
            int temp = my_string.charAt(i)-'0';
            if(temp>0&&temp<10){
                answer+=temp;
            }
        }
        return answer;
    }
}