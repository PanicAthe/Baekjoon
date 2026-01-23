import java.util.*;

class Solution {
    
    // 최대 점수차
    static int maxDif;
    static int[] globalInfo;
    static int[] answer;
    
    public int[] solution(int n, int[] info) {
        maxDif = 0; // 초기화 필수
        answer = new int[]{-1}; // 초기화 필수
        globalInfo = info;
        dfs(0, new int[11], 0, n);
        return answer;
    }
    
    public static void dfs(int index, int[] lionInfo, int dif, int left){
        
        if(index==11){
            // 라이언이 우승하고 최대 점수라면
            if(dif>0 && dif>=maxDif){
                // 가장 낮은 점수에 남은 화살 처리
                lionInfo[10] += left;
                if(dif>maxDif){
                    maxDif = dif;
                    answer = lionInfo.clone();
                }else{
                    for(int i=10; i>=0; i--){
                        if(lionInfo[i]>answer[i]){
                            answer = lionInfo.clone();
                            break;
                        }else if(lionInfo[i]<answer[i]){
                            break;
                        }
                    }
                }
                lionInfo[10] -= left;
            }
            return;
            
        }else{
            
            // 현재 index에서 무승부인 경우
            if(globalInfo[index]==0){
                dfs(index+1, lionInfo, dif, left);
            }
            // 현재 index에서 어피치가 점수를 얻는 경우
            if(globalInfo[index]>0){
                dfs(index+1, lionInfo, dif-(10-index), left);
            }
            
            // 현재 index에서 라이언이 점수를 얻는 경우
            if(globalInfo[index]<left){
                lionInfo[index] = globalInfo[index]+1;
                dfs(index+1, lionInfo, dif+(10-index), left- lionInfo[index]);
                lionInfo[index] = 0;
            }            
            
        }
    }
}