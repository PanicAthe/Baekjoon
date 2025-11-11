import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] counts = new int[N+1]; // 스테이지들의 현재 사용자 count
        
        for(int i=0; i<stages.length; i++){
            counts[stages[i]-1]++;
        }
        
        HashMap<Integer, Double> map = new HashMap<>();
        int count = stages.length;  // 앞 스테이지에 있는 사용자 count
        for(int i=0; i<counts.length-1;i++){
            if(counts[i]==0){
                map.put(i+1, 0.0);
            }
            else{
                map.put(i+1, (double)counts[i]/count);
            }
            count -= counts[i];
        }
        
        return map.entrySet().stream().sorted((o1,o2) -> 
                o1.getValue().equals(o2.getValue()) ? Integer.compare(o1.getKey(), o2.getKey()) :
                                             Double.compare(o2.getValue(), o1.getValue())).mapToInt(Map.Entry::getKey).toArray();
        
    }
}