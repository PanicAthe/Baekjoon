class Solution {
    public String solution(int[] numLog) {
        String answer = "";
        int n = numLog[0];
        for(int i=1; i<numLog.length;i++){
            if(numLog[i]==n+1){
                answer += "w";
            }else if(numLog[i]==n-1){
                answer+="s";
            }else if(numLog[i]==n-10){
                answer+="a";
            }else if(numLog[i]==n+10){
                answer+="d";
            }
            n = numLog[i];
        }
        return answer;
    }
}