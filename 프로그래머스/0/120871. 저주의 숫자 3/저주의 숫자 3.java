class Solution {
    public int solution(int n) {
        int[] arr = new int[101];
        arr[1] = 1;
        for(int i=2; i<=n; i++){
            arr[i]=arr[i-1]+1;
            while(arr[i]%3==0||String.valueOf(arr[i]).contains("3")){
                arr[i]++;
            }
        }
        return arr[n];
    }
}