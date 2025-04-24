class Solution {
    public String solution(String myString, String pat) {
        for(int i=myString.length(); i>pat.length()-1;i--){
            if(myString.substring(i-pat.length(),i).equals(pat))
                return myString.substring(0,i);
        }
        return "";
    }
}