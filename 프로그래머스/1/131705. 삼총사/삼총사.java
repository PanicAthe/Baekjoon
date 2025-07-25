
class Solution {

    static int[] students;
    static int answer = 0;

    public int solution(int[] number) {
        students = number;
        three(0, 0,0,new int[number.length]);
        return answer;
    }

    public void three(int count, int sum, int index, int[] counted){

        if(count==3 && sum==0){
            answer++;
        }
        for(int i=index; i<students.length; i++){
            if(counted[i]==1) continue;
            counted[i] = 1;
            three(count+1, sum+students[i], i, counted);
            counted[i] = 0;
        }

    }
}
