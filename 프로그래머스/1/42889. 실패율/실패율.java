import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        Stage[] stageArray = new Stage[N];
        int userCount = stages.length;

        for (int i = 0; i < N; i++) {
            stageArray[i] = new Stage(i + 1); 
        }

        // 각 스테이지 사람 count
        for (int stage : stages) {
            if (stage <= N) {
                stageArray[stage - 1].stay++;
            }
        }

        // 실패율 
        for (int i = 0; i < N; i++) {
            if (userCount == 0) {
                stageArray[i].failRate = 0;
            } else {
                stageArray[i].failRate = (double) stageArray[i].stay / userCount;
            }
            userCount -= stageArray[i].stay;
        }

        Arrays.sort(stageArray, (a, b) -> {
            if (Double.compare(b.failRate, a.failRate) != 0) {
                return Double.compare(b.failRate, a.failRate); // 실패율 우선
            } else {
                return Integer.compare(a.number, b.number); // 스테이지 번호 오름차순
            }
        });

        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[i] = stageArray[i].number;
        }

        return result;
    }

    // 스테이지 클래스
    class Stage {
        int number;      
        int stay = 0;    
        double failRate; 

        Stage(int number) {
            this.number = number;
        }
    }
}
