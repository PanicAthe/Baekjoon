class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for(int[] index : queries){
            int temp = arr[index[0]];
            arr[index[0]] = arr[index[1]];
            arr[index[1]] = temp;
        }
        return arr;
    }
}