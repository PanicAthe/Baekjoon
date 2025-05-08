class Solution {
    public int solution(int[] common) {
        int answer = 0;
        int n = common.length;
        int d = common[1]-common[0];
        int r;
        if(common[0]!=0){
            r = common[1]/common[0];
            if(common[n-1]==common[0]*Math.pow(r,n-1)){
                return common[n-1]*r;
            }
        }
        return common[n-1]+d;
    }
}