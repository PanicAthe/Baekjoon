class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for (int i = 0; i < quiz.length; i++) {
            String[] words = quiz[i].split(" ");
            int x = Integer.parseInt(words[0]);
            String op = words[1];
            int y = Integer.parseInt(words[2]);
            int z = Integer.parseInt(words[4]);
            if(op.equals("-")) {
                answer[i] = (x-y==z)? "O":"X";
            }else if(op.equals("+")) {
                answer[i] = (x+y==z)? "O":"X";
            }
        }
        return answer;
    }
}