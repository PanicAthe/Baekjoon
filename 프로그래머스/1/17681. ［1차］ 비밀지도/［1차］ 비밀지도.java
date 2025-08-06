class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int i=0; i<n; i++){
            String n1 = "";
            String n2 = "";
            while(arr1[i]>1){
                n1 = arr1[i]%2 + n1;
                arr1[i]/=2;
            }
            n1 = arr1[i]%2 + n1;
            
            while(arr2[i]>1){
                n2 = arr2[i]%2 + n2;
                arr2[i]/=2;
            }
            n2 = arr2[i]%2 + n2;

            //0으로 남은 자릿수 채우기
            if(n1.length() < n) {
                while(n1.length() < n) {
                    n1 = "0" + n1;
                }
            }

            if(n2.length() < n) {
                while(n2.length() < n) {
                    n2 = "0" + n2;
                }
            }

            StringBuilder sb = new StringBuilder();
            for(int j=0; j<n; j++){
                if(n1.charAt(j) == '1' || n2.charAt(j) == '1') {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}
