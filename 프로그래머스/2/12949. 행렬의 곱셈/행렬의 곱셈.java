class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        
        int m = arr1.length;    // 행렬1 행
        int n = arr1[0].length; // 행렬1 열
        int r = arr2[0].length; // 행렬2 열
        
        int[][] answer = new int[m][r];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<r; j++){
                for(int k=0; k<n; k++){
                    answer[i][j] += arr1[i][k]*arr2[k][j];
                }
            }
        }
        
        return answer;
    }
}