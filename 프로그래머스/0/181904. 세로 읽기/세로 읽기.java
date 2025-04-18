class Solution {
    public String solution(String my_string, int m, int c) {
        if(m==1)
            return my_string;
        String answer = "";
        int len = my_string.length();
        for(int i=0; i<len/m; i++){
            answer+=my_string.charAt(i*m+c-1);
        }
        return answer;
    }
}