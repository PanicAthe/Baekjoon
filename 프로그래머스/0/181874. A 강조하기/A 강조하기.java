class Solution {
    public String solution(String myString) {
        String result = "";
        for(int i=0; i<myString.length(); i++){
            char c = myString.charAt(i);
            if(c=='a'){
                result += "A";
            }else if(c<='Z'&&c>='B'){
                result += (char)(c+32);
            }else{
                result+=c;
            }
        }
        return result;
    }
}