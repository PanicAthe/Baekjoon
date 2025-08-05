import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = new int[3];

        int[][] students = {
            {1, 2, 3, 4, 5}, // Student 1
            {2, 1, 2, 3, 2, 4, 2, 5}, // Student 2
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5} // Student 3
        };

        for(int i=0; i<answers.length; i++) {
            for(int j=0; j<students.length; j++) {
                if(answers[i] == students[j][i % students[j].length]) {
                    answer[j]++;
                }
            }
        }

        if(answer[0]>answer[1] && answer[0]>answer[2]) {
            return new int[]{1};
        } else if(answer[1]>answer[0] && answer[1]>answer[2]) {
            return new int[]{2};
        } else if(answer[2]>answer[0] && answer[2]>answer[1]) {
            return new int[]{3};
        } else {
            int maxScore = Math.max(Math.max(answer[0], answer[1]), answer[2]);
            List<Integer> winners = new ArrayList<>();
            for (int i = 0; i < answer.length; i++) {
                if (answer[i] == maxScore) {
                    winners.add(i + 1);
                }
            }
            return winners.stream().mapToInt(i -> i).toArray();
        }

    }
}