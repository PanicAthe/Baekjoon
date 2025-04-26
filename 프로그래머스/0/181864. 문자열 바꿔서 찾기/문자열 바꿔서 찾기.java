class Solution {
    public int solution(String myString, String pat) {
        String s = "";
        for(char c : myString.toCharArray()){
            if(c=='A'){
                s+='B';
            }else if(c=='B'){
                s+='A';
            }else{
                s+=c;
            }
        }
        return s.contains(pat) ? 1 : 0;
    }
}