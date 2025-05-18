import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<Integer>();
        
        while(n!=1){
            boolean isPrime = false;
            for(int i=2; i<=n;i++){
                if(n%i==0){
                    n/=i;
                    isPrime = true; 
                    if(list.indexOf(i)==-1){
                        list.add(i);
                    }
                    break;
                }
            }
            if(!isPrime){
                break;
            }
        }
        
        return list.stream().mapToInt(i->i).toArray();
    }
}