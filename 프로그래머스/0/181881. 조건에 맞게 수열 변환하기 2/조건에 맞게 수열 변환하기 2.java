class Solution {
    public int solution(int[] arr) {
        int x = -1;
        while(true){
            x++;
            boolean fix = false;
            for(int i=0; i<arr.length; i++){
                if(arr[i]>=50 && arr[i]%2==0){
                    arr[i]/=2;
                    fix = true;
                }else if(arr[i]<50 && arr[i]%2==1){
                    arr[i]*=2;
                    arr[i]++;
                    fix = true;
                }
            }
            if(!fix){
                break;
            }
        }
        return x;
    }
}