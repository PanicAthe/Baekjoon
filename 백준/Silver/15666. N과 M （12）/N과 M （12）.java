import java.io.IOException;
import java.util.*;

public class Main {
    static int[] nums;
    static int[] result;
    static int m;
    static int n;

    static void dfs(int k, int count){
        if(count==m){
            for(int i = 0; i<m; i++){
                System.out.print(result[i]+" ");
            }
            System.out.println();
        }else{
            for(int i = k; i<n; i++){
                result[count] = nums[i];
                dfs(i, count+1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        result = new int[m];
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < n; i++){
            int temp  = sc.nextInt();
            if(!list.contains(temp)){
                list.add(temp);
            }
        }
        n = list.size();
        nums = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            nums[i] = list.get(i);
        }
        Arrays.sort(nums);

        dfs(0,0);
    }
}
