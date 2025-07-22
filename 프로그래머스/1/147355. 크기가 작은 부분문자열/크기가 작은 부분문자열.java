class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        Long pValue = Long.valueOf(p);
        for(int i=0; i<=t.length()-p.length(); i++){
            if(Long.valueOf(t.substring(i, i+p.length()))
                    <= pValue){
                answer++;
            }
        }
        return answer;
    }
}