class Solution {
    public int solution(int num, int k) {
        String s = String.valueOf(num);
        int result = s.indexOf(k+"");
        if(result==-1){
            return result;
        }
        return result+1;
    }
}