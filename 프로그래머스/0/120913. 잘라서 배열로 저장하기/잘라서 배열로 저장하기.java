class Solution {
    public String[] solution(String my_str, int n) {
        int len = my_str.length()/n;
        if(my_str.length()%n>0){
            len++;
        }
        String[] answer = new String[len];
        for(int i=0; i<len;i++){
            answer[i] = my_str.substring(0+i*n,Math.min(0+i*n+n, my_str.length()));
        }
        return answer;
    }
}