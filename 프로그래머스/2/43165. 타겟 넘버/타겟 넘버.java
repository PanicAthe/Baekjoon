class Solution {

    static int n, t, answer;
    static int[] nums;
    
    static void dfs(int index, int sum){
        if(index==n){
            if(sum==t){
                answer++;
            }
            return;
        }else{
            dfs(index+1, sum-nums[index]);
            dfs(index+1, sum+nums[index]);
        }
    }
        
    public int solution(int[] numbers, int target) {
        
        // numbers 를 활용하여 +, - 연산을 통해 target 만드는 경우의 수
        // numbers 의 순서를 바꾸지 않고 모두 사용해야 함
        
        answer = 0;
        n = numbers.length;
        t = target;
        nums = numbers;
        dfs(0, 0);
        return answer;
    }
}