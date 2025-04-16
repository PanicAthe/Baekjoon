import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > list.get(list.size()-1)) {
                list.add(arr[i]);
            }else{
                while(!list.isEmpty()){
                    if(list.get(list.size()-1) >= arr[i]){
                        list.remove(list.size()-1);
                    }else{
                        break;
                    }
                }
                list.add(arr[i]);
            }
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}