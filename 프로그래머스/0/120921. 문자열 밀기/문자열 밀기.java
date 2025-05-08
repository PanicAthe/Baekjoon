class Solution {
    public int solution(String A, String B) {
        int result = -1;
        StringBuilder sb = new StringBuilder(A);
        for (int i = 0; i < A.length(); i++) {
            if(sb.toString().equals(B)) {
                result = i;
                break;
            }
            sb.insert(0, sb.charAt(sb.length()-1));
            sb.delete(sb.length()-1, sb.length());
        }
        return result;
    }
}