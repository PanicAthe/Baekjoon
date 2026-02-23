import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        //DNA 길이
        int S = Integer.parseInt(temp[0]);
        //부분문자열 길이
        int P = Integer.parseInt(temp[1]);
        //DNA 
        String str = br.readLine();

        char[] charArr = new char[]{'A', 'C', 'G', 'T'};

        // 각 문자의 인덱스 설정
        HashMap<Character, Integer> index = new HashMap<>();
        index.put('A', 0);
        index.put('C', 1);
        index.put('G', 2);
        index.put('T', 3);
        
        //각 문자 {A, C, G T}가 포함되어야 하는 수
        HashMap<Character, Integer> condition = new HashMap<>();
        temp = br.readLine().split(" ");
        for(int i=0; i<4; i++){
            condition.put(charArr[i], Integer.parseInt(temp[i]));
        }

        // 현재 부분문자열에 포함된 각 문자 {A, C, G T}의 개수를 저장할 배열
        int[] countArr = new int[4];

        int result = 0;
        // 첫 부분 문자열 각 문자의 개수 세기
        for(int i=0; i<P; i++){
            countArr[index.get(str.charAt(i))]++;
        }
        // 첫 부분 문자열이 모든 조건을 만족하는지 확인
        boolean check = true;
        for(int i=0; i<4; i++){
            if(countArr[index.get(charArr[i])] < condition.get(charArr[i])){
                check = false;
                break;
            }
        }
        if(check) result++;

        // 슬라이딩 윈도우
        for(int i=0; i<S-P; i++){
            // 지울 글자
            char deleteChar = str.charAt(i);
            // 더할 글자
            char addChar = str.charAt(i+P);
            countArr[index.get(deleteChar)]--;
            countArr[index.get(addChar)]++;
           
            // 직전에 DNA 문자열이였다면 지운 글자만 조건 확인
            if(check){
                if(countArr[index.get(deleteChar)] < condition.get(deleteChar)){
                        check = false;
                }
            }else{
                check = true;
                for(int j=0; j<4; j++){
                    if(countArr[index.get(charArr[j])] < condition.get(charArr[j])){
                        check = false;
                        break;
                    }
                }
            }
            if(check) result++; 
        }
        
        System.out.print(result);
    }
}