import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<Integer>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }
        while(q.size() > 1) {
            q.remove();
            q.add(q.remove());
        }
        System.out.println(q.remove());
    }
}
