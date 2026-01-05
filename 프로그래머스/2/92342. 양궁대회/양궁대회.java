import java.util.*;

class Solution {
    
    int[] globalInfo;
    int[] answer;
    int dif = 0;
    
    public void dfs(int arrow, int index, int[] arr, int peach, int lion){
        if(index==11){
            // 라이언과 어피치의 점수 차
            int temp = lion - peach;
            
            // 라이언이 이겼다면
            if(temp>0){
                arr[10] += arrow;
                if(dif==temp){
                    // 가장 낮은 점수를 더 많이 맞힌 경우를 찾기
                    for (int i = 10; i >= 0; i--) {
                        if (arr[i] > answer[i]) {
                            answer = Arrays.copyOf(arr, 11);
                            break;
                        } else if (arr[i] < answer[i]) {
                            break;
                        }
                    }

                }else if(dif<temp){
                    dif = temp;
                    answer = Arrays.copyOf(arr, 11);
                }
                arr[10] -= arrow;
            }
            return;
        }
        int peachArrow = globalInfo[index];
        // 라이언은 현재 점수에 화살을 맞히지 못함
        if(peachArrow>0){
            // 어피치가 현재 점수를 획득
            dfs(arrow, index+1, arr, peach+10-index, lion);
        }else{
            // 라이언과 어피치 모두 현재 점수에 단 하나의 화살도 맞히지 못함.
            dfs(arrow, index+1, arr, peach, lion);
        }
        // 라이언이 현재 점수 획득
        if(peachArrow<arrow){
            arr[index] = peachArrow + 1;
            dfs(arrow-arr[index], index+1, arr, peach, lion+10-index);
            arr[index] = 0;
        }
    }
    
    public int[] solution(int n, int[] info) {
        globalInfo = info;
        answer = new int[11];
        dfs(n, 0, new int[11], 0, 0);
        if(dif==0) return new int[]{-1};
        return answer;
    }
}