import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        while(n-->0){
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();
            for(int i=0; i<str.length(); i++){
                char c = str.charAt(i);
                if(c=='('){
                    stack.push('(');
                }else{
                    if(!stack.isEmpty() && stack.peek()=='('){
                        stack.pop();
                    }else{
                        stack.push(')');
                    }
                }
            }
            if(stack.isEmpty()){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}