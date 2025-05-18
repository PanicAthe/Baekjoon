class Solution {
    public int solution(String s) {
        String[] arg = s.split(" ");
        int result = 0;
        int pre = 0;
        for(int i=0; i<arg.length;i++){
            if(arg[i].equals("Z")){
                result -= pre;
            }else{
                result += Integer.parseInt(arg[i]);
                pre = Integer.parseInt(arg[i]);
            }
        }
        return result;
    }
}