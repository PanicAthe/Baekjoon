import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 스위치 개수
        int n = Integer.parseInt(br.readLine());
        // 스위치 상태
        int[] switchState = new int[n];
        // 스위치 상태 초기화
        String[] str = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            switchState[i] = Integer.parseInt(str[i]);
        }

        // 학생 수
        int studentN = Integer.parseInt(br.readLine());
        // 학생 수 만큼 처리
        while(studentN-->0){
            String[] studentInfo = br.readLine().split(" ");
            int student = Integer.parseInt(studentInfo[0]);
            int switchNum = Integer.parseInt(studentInfo[1]);
            
            if(student==1){
                //남학생인 경우
                for(int i=switchNum-1; i<n; i+=switchNum){
                    switchState[i] = switchState[i]==1 ? 0 : 1;
                }
            }else{
                //여학생인 경우
                int left = switchNum-1;
                int right = switchNum-1;
                while(left>=0 && right<n && switchState[left] == switchState[right]){
                    switchState[left] = switchState[left]==1 ? 0 : 1;
                    switchState[right++] = switchState[left--];
                }
            }
        }

        for(int i=0; i<n; i++){
            if(i%20==0 && i!=0){
                System.out.println();
            }
            System.out.print(switchState[i]+" ");
        }
    }
}